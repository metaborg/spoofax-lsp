package org.metaborg.spoofax.lsp.services.workspace.filter

import org.apache.http.client.utils.URIBuilder
import java.net.URI

/**
 * Created by Thomas on 4-7-2017.
 */
class UriSchemeFilter : UriFilter {

    override fun process(uri: String): String = URIBuilder(uri).setScheme("workspace").toString()

}