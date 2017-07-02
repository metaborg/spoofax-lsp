package org.metaborg.spoofax.lsp.services.workspace

import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.TextDocumentContentChangeEvent
import org.slf4j.LoggerFactory

/**
 * @author  Thomas Kluiters
 * @since   1.0.0
 */
class VirtualWorkspaceDocumentData(private val data : StringBuilder = StringBuilder()) {

    companion object {
        val logger = LoggerFactory.getLogger(VirtualWorkspaceDocumentData::class.java)
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
        return -1
    }

    /**
     * Applies the given [TextDocumentContentChangeEvent] to this document.
     *
     * @param change the change that have to be applied to this document
     */
    fun applyChange(change: TextDocumentContentChangeEvent): Unit {

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