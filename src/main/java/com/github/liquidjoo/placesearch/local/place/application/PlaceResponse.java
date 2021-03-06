package com.github.liquidjoo.placesearch.local.place.application;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class PlaceResponse {

    private final List<PlaceDocument> placeDocuments;
    private final MetaDocument metaDocument;

    public PlaceResponse(final List<PlaceDocument> placeDocuments, final MetaDocument metaDocument) {
        this.placeDocuments = placeDocuments;
        this.metaDocument = metaDocument;
    }

    public List<PlaceDocument> getPlaceDocuments() {
        return new ArrayList<>(placeDocuments);
    }

    public MetaDocument getMetaDocument() {
        return metaDocument;
    }

    @Getter
    @ToString
    public static class PlaceDocument {
        private String placeName;
        private String placeUrl;
        private String categoryName;
        private String addressName;
        private String roadAddressName;
        private String phone;
        private String linkUrl;

        public PlaceDocument(final String placeName, final String placeUrl, final String categoryName, final String addressName, final String roadAddressName, final String phone, final String linkUrl) {
            this.placeName = placeName;
            this.placeUrl = placeUrl;
            this.categoryName = categoryName;
            this.addressName = addressName;
            this.roadAddressName = roadAddressName;
            this.phone = phone;
            this.linkUrl = linkUrl;
        }
    }

    @Getter
    @ToString
    public static class MetaDocument {
        private boolean isEnd;
        private int pageableCount;
        private int totalCount;
        private int size;
        private int page;

        public MetaDocument(final boolean isEnd, final int pageableCount, final int totalCount, final int size, final int page) {
            this.isEnd = isEnd;
            this.pageableCount = pageableCount;
            this.totalCount = totalCount;
            this.size = size;
            this.page = page;
        }
    }
}
