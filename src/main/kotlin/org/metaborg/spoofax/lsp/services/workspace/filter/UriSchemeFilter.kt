package org.metaborg.spoofax.lsp.services.workspace.filter

import org.apache.http.client.utils.URIBuilder
import java.net.URI

/**
 * @author  Thomas Kluiters
 * @since   1.0.0
 */
class UriSchemeFilter : UriFilter {

    override fun process(uri: String): String = URIBuilder(uri).setScheme("workspace").toString()

}