package org.metaborg.spoofax.lsp

import com.google.inject.Inject
import org.eclipse.lsp4j.InitializeParams
import org.eclipse.lsp4j.InitializeResult
import org.eclipse.lsp4j.services.*
import org.metaborg.spoofax.lsp.services.SpoofaxTextDocumentService
import org.metaborg.spoofax.lsp.services.SpoofaxWorkspaceService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
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

    companion object {
        val logger: Logger = LoggerFactory.getLogger(SpoofaxLanguageServer::class.java)
    }

    override fun initialize(initializeParams: InitializeParams?): CompletableFuture<InitializeResult> {
        return CompletableFuture.supplyAsync {
            logger.info("Initialising new Language Server instance")
            InitializeResult()
        }
    }

    override fun shutdown(): CompletableFuture<Any> {
        return CompletableFuture.supplyAsync({
            logger.info("Shutting down Language Server instance")
        })
    }

    override fun exit() {
        logger.info("Exiting Language server instance")
    }

    override fun getTextDocumentService() = textDocumentService

    override fun getWorkspaceService() = workspaceService

    override fun connect(client: LanguageClient?) {
        when(client) {
            null -> {
                logger.error("Could not connect with language client because it was null, shutting down")
                shutdown()
            }
            else -> {
                textDocumentService.connect(client)
                workspaceService.connect(client)
            }
        }
    }

}