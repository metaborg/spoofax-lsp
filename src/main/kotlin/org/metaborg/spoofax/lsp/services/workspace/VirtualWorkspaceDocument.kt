package org.metaborg.spoofax.lsp.services.workspace

import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.TextDocumentContentChangeEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author  Thomas Kluiters
 * @since   1.0.0
 */
class VirtualWorkspaceDocument(private val data : StringBuilder = StringBuilder()) {

    companion object {
        val delimiters = listOf("\r\n", "\n", "\r")

        val logger: Logger = LoggerFactory.getLogger(VirtualWorkspaceDocument::class.java)
    }

    private var version = 0;

    /**
     * Computes the offset (absolute index) of the given position (line : character).
     *
     * @param position the position (line : character).
     *
     * @return the offset of the given position or null if the position is not in this document.
     */
    fun computeOffset(position: Position): Int? {
        val lineOffset = (0..position.line).reduce { index, _ ->
            when(index) {
                -1   -> -1
                else -> data.indexOfAny(delimiters, index);
            }
        }
        val offset = lineOffset + position.character + if (lineOffset > 0) 0 else -1
        return when (lineOffset == -1 || offset > data.length) {
            true -> null
            false-> offset
        }
    }

    /**
     * Applies the given [TextDocumentContentChangeEvent] to this document.
     *
     * @param change the change that have to be applied to this document
     */
    fun applyChange(change: TextDocumentContentChangeEvent): Unit {
        version.inc()
        change.range?.apply {
            val startOffset = computeOffset(start) ?:
                    return logger.warn("Start {} is out of bounds", start)
            val endOffset   = computeOffset(end) ?:
                    return logger.warn("End {} is out of bounds", end)
            when(startOffset) {
                data.length -> data.append(change.text)
                else        -> data.replace(startOffset, endOffset, change.text)
            }
        } ?: setText(change.text)
    }

    /**
     * Clears the current data buffer and appends the given text to it.
     *
     * @param text the new text this document is initialised with.
     */
    fun setText(text : String) {
        data.setLength(0)
        data.append(text)
    }

    /**
     * Returns the content of this document in a [String] format.
     *
     * @return this documents' content.
     */
    fun getText() = data.toString()
}