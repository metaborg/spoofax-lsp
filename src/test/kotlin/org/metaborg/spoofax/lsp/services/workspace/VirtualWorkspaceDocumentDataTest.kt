package org.metaborg.spoofax.lsp.services.workspace

import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.TextDocumentContentChangeEvent
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals
import kotlin.test.assertNull

internal class VirtualWorkspaceDocumentDataTest : Spek({

    fun createEvent(position : Position, text: String): TextDocumentContentChangeEvent =
            TextDocumentContentChangeEvent(Range(position, position), 0, text)

    fun createEvent(range: Range, text: String): TextDocumentContentChangeEvent =
        TextDocumentContentChangeEvent(range, 0, text)

    given("a text document with the text 'hello world\n' appended to") {

        val document = VirtualWorkspaceDocument()
        document.applyChange(createEvent(Position(0, 0), "hello world\n"))

        it("should return 'hello world'\n' if it's content is queried") {
            assertEquals("hello world\n", document.getText())
        }

        on("applying a change event with text 'foo\n' to the end of the document") {
            document.applyChange(createEvent(Position(1, 1), "foo\n"))
            it("should return 'hello world\nfoo\n when it's content is queried") {
                assertEquals("hello world\nfoo\n", document.getText())
            }
        }

        on("applying a change event with text 'bar\n' to the start of the document") {
            document.applyChange(createEvent(Position(0, 1), "bar\n"))
            it("should return 'bar\nhello world\nfoo\n when it's content is queried") {
                assertEquals("bar\nhello world\nfoo\n", document.getText())
            }
        }

    }

    given("a document initialised with the string 'hello world\n'") {

        val document = VirtualWorkspaceDocument(StringBuilder("hello world\n"))

        on("computing the offset with position (0, 1)") {
            val offset = document.computeOffset(Position(0, 1))
            it("should return 0") {
                assertEquals(0, offset)
            }
        }

        on("computing the offset with position (0, 1)") {
            val offset = document.computeOffset(Position(0, 1))
            it("should return 1") {
                assertEquals(1, offset)
            }
        }

        on("computing the offset with position (1, 1)") {
            val offset = document.computeOffset(Position(1, 1))
            it("should return 11") {
                assertEquals(11, offset)
            }
        }

        on("computing the offset with position (1, 2)") {
            val offset = document.computeOffset(Position(1, 2))
            it("should return null") {
                assertEquals(null, offset)
            }
        }

    }

    given("a document initialised with the string 'hello world'") {

        val document = VirtualWorkspaceDocument(StringBuilder("hello world"))

        on("computing the offset with position (0, 1)") {
            val offset = document.computeOffset(Position(0, 1))
            it("should return 0") {
                assertEquals(0, offset)
            }
        }

        on("computing the offset with position (0, 2)") {
            val offset = document.computeOffset(Position(0, 2))
            it("should return 1") {
                assertEquals(1, offset)
            }
        }

        on("computing the offset with position (1, 0)") {
            val offset = document.computeOffset(Position(1, 0))
            it("should return null") {
                assertEquals(null, offset)
            }
        }

        on("computing the offset with position (1, 1)") {
            val offset = document.computeOffset(Position(1, 1))
            it ("should return null") {
                assertNull(offset)
            }
        }

    }

})