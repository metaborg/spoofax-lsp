package org.metaborg.spoofax.lsp.services.workspace.filter

/**
 * Created by Thomas on 4-7-2017.
 */
interface UriFilter {

    fun process(uri: String): String

}