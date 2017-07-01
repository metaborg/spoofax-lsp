package org.metaborg.spoofax.lsp.services

import org.eclipse.lsp4j.*
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.lsp4j.services.LanguageClientAware
import org.eclipse.lsp4j.services.TextDocumentService
import java.util.concurrent.CompletableFuture

/**
 * The [SpoofaxTextDocumentService] services document-specific features.
 *
 * Document changes are handled in [didOpen], [didChange], [didSave] and [didClose] methods. These methods
 * are responsible for updating existing documents or creating new documents in the servers' virtual workspace.
 *  *
 * @author  Thomas Kluiters
 * @since   1.0.0
 */
class SpoofaxTextDocumentService : TextDocumentService, LanguageClientAware {

    private var client : LanguageClient? = null

    override fun connect(client: LanguageClient?) {
        this.client = client
    }

    override fun resolveCompletionItem(unresolved: CompletionItem?): CompletableFuture<CompletionItem> {
        TODO("not implemented")
    }

    override fun codeAction(params: CodeActionParams?): CompletableFuture<MutableList<out Command>> {
        TODO("not implemented")
    }

    override fun hover(position: TextDocumentPositionParams?): CompletableFuture<Hover> {
        TODO("not implemented")
    }

    override fun documentHighlight(position: TextDocumentPositionParams?): CompletableFuture<MutableList<out DocumentHighlight>> {
        TODO("not implemented")
    }

    override fun onTypeFormatting(params: DocumentOnTypeFormattingParams?): CompletableFuture<MutableList<out TextEdit>> {
        TODO("not implemented")
    }

    override fun definition(position: TextDocumentPositionParams?): CompletableFuture<MutableList<out Location>> {
        TODO("not implemented")
    }

    override fun rangeFormatting(params: DocumentRangeFormattingParams?): CompletableFuture<MutableList<out TextEdit>> {
        TODO("not implemented")
    }

    override fun codeLens(params: CodeLensParams?): CompletableFuture<MutableList<out CodeLens>> {
        TODO("not implemented")
    }

    override fun rename(params: RenameParams?): CompletableFuture<WorkspaceEdit> {
        TODO("not implemented")
    }

    override fun completion(position: TextDocumentPositionParams?): CompletableFuture<Either<MutableList<CompletionItem>, CompletionList>> {
        TODO("not implemented")
    }

    override fun documentSymbol(params: DocumentSymbolParams?): CompletableFuture<MutableList<out SymbolInformation>> {
        TODO("not implemented")
    }

    override fun didOpen(params: DidOpenTextDocumentParams?) {
        TODO("not implemented")
    }

    override fun didSave(params: DidSaveTextDocumentParams?) {
        TODO("not implemented")
    }

    override fun signatureHelp(position: TextDocumentPositionParams?): CompletableFuture<SignatureHelp> {
        TODO("not implemented")
    }

    override fun didClose(params: DidCloseTextDocumentParams?) {
        TODO("not implemented")
    }

    override fun formatting(params: DocumentFormattingParams?): CompletableFuture<MutableList<out TextEdit>> {
        TODO("not implemented")
    }

    override fun didChange(params: DidChangeTextDocumentParams?) {
        TODO("not implemented")
    }

    override fun references(params: ReferenceParams?): CompletableFuture<MutableList<out Location>> {
        TODO("not implemented")
    }

    override fun resolveCodeLens(unresolved: CodeLens?): CompletableFuture<CodeLens> {
        TODO("not implemented")
    }

}