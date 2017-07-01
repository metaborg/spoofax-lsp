package org.metaborg.spoofax.lsp

import com.google.inject.Inject
import org.eclipse.lsp4j.InitializeParams
import org.eclipse.lsp4j.InitializeResult
import org.eclipse.lsp4j.services.*
import org.metaborg.spoofax.lsp.services.SpoofaxTextDocumentService
import org.metaborg.spoofax.lsp.services.SpoofaxWorkspaceService
import java.util.concurrent.CompletableFuture

/**
 * The Spoofax Language Server class.
 *
 * This class serves the connected [LanguageClient] [WorkspaceService] and [TextDocumentService] services.
 *
 * @author  Thomas Kluiters
 * @since   1.0.0
 */
class SpoofaxLanguageServer @Inject constructor(
        private val textDocumentService: SpoofaxTextDocumentService,
        private val workspaceService: SpoofaxWorkspaceService
) : LanguageServer, LanguageClientAware {

    override fun initialize(initializeParams: InitializeParams?): CompletableFuture<InitializeResult> {
        TODO("not implemented")
    }

    override fun shutdown(): CompletableFuture<Any> {
        TODO("not implemented")
    }

    override fun exit() {
        TODO("not implemented")
    }

    override fun getTextDocumentService() = textDocumentService

    override fun getWorkspaceService() = workspaceService

    override fun connect(client: LanguageClient?) {
        textDocumentService.connect(client)
        workspaceService.connect(client)
    }

}