package org.apache.solr.cloud.admin;

import org.apache.solr.api.Command;
import org.apache.solr.api.EndPoint;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.core.CoreContainer;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.response.SolrQueryResponse;
import org.apache.solr.security.PermissionNameProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CollectionAdmin {
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final CoreContainer coreContainer;

    public final List list = new List();

    public CollectionAdmin(CoreContainer coreContainer) {
        this.coreContainer = coreContainer;
    }

    @EndPoint(
            path = "/collectionsv2",
            method = SolrRequest.METHOD.GET,
            permission = PermissionNameProvider.Name.COLL_READ_PERM)
    public class List {
        @Command
        public void list(SolrQueryRequest req, SolrQueryResponse rsp) {
            log.info("Getting the list of collections using the new API");
            rsp.add("collections", "dummy response");
            return;
        }
    }
}
