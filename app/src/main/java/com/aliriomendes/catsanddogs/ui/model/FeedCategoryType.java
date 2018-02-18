package com.aliriomendes.catsanddogs.ui.model;

public enum FeedCategoryType { CATS("Cats"), DOGS("Dogs"), PUBLIC_FEED("Public Feed");

    private final String text;

    /**
     * @param text
     */
    FeedCategoryType(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
