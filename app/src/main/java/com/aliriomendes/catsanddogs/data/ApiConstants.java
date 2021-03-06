package com.aliriomendes.catsanddogs.data;

/**
 * Created by aliriomendes on 15/02/2018.
 */

public class ApiConstants {
    public static final String ENDPOINT = "http://api.flickr.com/";
    public static final String ENDPOINT_FEED = "services/feeds/photos_public.gne?lang=en-us&format=json&nojsoncallback=1";
    public static final String ENDPOINT_CATS_FEED = "services/feeds/photos_public.gne?lang=en-us&format=json&nojsoncallback=1&tags=pet,cat";
    public static final String ENDPOINT_DOGS_FEED = "services/feeds/photos_public.gne?lang=en-us&format=json&nojsoncallback=1&tags=pet,dog";
}
