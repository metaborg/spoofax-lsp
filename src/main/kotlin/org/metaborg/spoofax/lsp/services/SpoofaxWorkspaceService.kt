package org.metaborg.spoofax.lsp.services

import org.eclipse.lsp4j.*
import org.eclipse.lsp4j.services.WorkspaceService
import java.util.concurrent.CompletableFuture

/**
 * The [SpoofaxWorkspaceService] services workspace-specific features.
 *
 * Perhaps the most important method of this service is the [executeCommand] method. Later in development
 * commands such as compilation, transformation, testing and other workspace-wide features will be accessible
 * through this method.
 *
 * @author  Thomas Kluiters
 * @since   1.0.0
 */
class SpoofaxWorkspaceService : WorkspaceService {

    override fun executeCommand(params: ExecuteCommandParams?): CompletableFuture<Any> {
        TODO("not implemented")
    }

    override fun didChangeWatchedFiles(params: DidChangeWatchedFilesParams?) {
        TODO("not implemented")
    }

    override fun didChangeConfiguration(params: DidChangeConfigurationParams?) {
        TODO("not implemented")
    }

    override fun symbol(params: WorkspaceSymbolParams?): CompletableFuture<MutableList<out SymbolInformation>> {
        TODO("not implemented")
    }

}