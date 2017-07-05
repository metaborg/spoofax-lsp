package org.metaborg.spoofax.lsp.services.diagnostic

import org.apache.commons.vfs2.FileObject
import org.eclipse.lsp4j.Diagnostic
import org.metaborg.spoofax.lsp.services.workspace.VirtualWorkspaceFileObject

/**
 * @author  Thomas Kluiters
 * @since   1.0.0
 */
interface SpoofaxAnalysisDiagnosticService {

    fun diagnose(file: VirtualWorkspaceFileObject, root: FileObject): List<Diagnostic>

}