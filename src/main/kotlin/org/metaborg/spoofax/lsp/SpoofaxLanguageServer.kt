package org.metaborg.spoofax.lsp

import org.eclipse.lsp4j.InitializeParams
import org.eclipse.lsp4j.InitializeResult
import org.eclipse.lsp4j.services.*
import java.util.concurrent.CompletableFuture

/**
 * The Spoofax Language Server class.
 *
 * This class serves the connected [LanguageClient] [WorkspaceService] and [TextDocumentService] services.
 *
 * @author Thomas Kluiters
 * @since 1.0.0
 */
class SpoofaxLanguageServer : LanguageServer, LanguageClientAware {

    override fun initialize(initializeParams: InitializeParams?): CompletableFuture<InitializeResult> {
        TODO("not implemented")
    }

    override fun shutdown(): CompletableFuture<Any> {
        TODO("not implemented")
    }

    override fun exit() {
        TODO("not implemented")
    }

    override fun getTextDocumentService(): TextDocumentService {
        TODO("not implemented")
    }

    override fun getWorkspaceService(): WorkspaceService {
        TODO("not implemented")
    }

    override fun connect(client: LanguageClient?) {
        TODO("not implemented")
    }

}