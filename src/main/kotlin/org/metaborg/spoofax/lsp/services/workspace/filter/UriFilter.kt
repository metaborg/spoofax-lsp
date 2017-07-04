package org.metaborg.spoofax.lsp.services.workspace.filter

/**
 * @author  Thomas Kluiters
 * @since   1.0.0
 */
interface UriFilter {

    fun process(uri: String): String

}