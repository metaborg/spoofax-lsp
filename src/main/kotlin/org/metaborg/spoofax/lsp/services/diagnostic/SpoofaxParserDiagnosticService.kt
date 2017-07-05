package org.metaborg.spoofax.lsp.services.diagnostic

import org.eclipse.lsp4j.Diagnostic
import org.metaborg.spoofax.lsp.services.workspace.VirtualWorkspaceFileObject

/**
 * @author  Thomas Kluiters
 * @since   1.0.0
 */
interface SpoofaxParserDiagnosticService {

    fun performParsing(file: VirtualWorkspaceFileObject): List<Diagnostic>

}