package com.jn.langx.classpath.cp;

import com.jn.langx.classpath.Classpaths;
import com.jn.langx.io.resource.InputStreamResource;
import com.jn.langx.io.resource.Location;
import com.jn.langx.io.resource.Resource;
import com.jn.langx.io.resource.Resources;
import com.jn.langx.util.collection.Collects;

import java.io.InputStream;
import java.util.Set;

public class InputStreamClasspath extends AbstractClasspath {

    private InputStreamResource resource;

    public InputStreamClasspath(String desc, InputStream inputStream) {
        resource = Resources.asInputStreamResource(inputStream, desc);
    }

    @Override
    public Resource findResource(String relativePath) {
        relativePath = Classpaths.getCanonicalFilePath(relativePath);
        if (relativePath.equals(resource.getDescription())) {
            return resource;
        }
        return null;
    }

    @Override
    public Location getRoot() {
        return resource.getLocation();
    }

    @Override
    public Set<Location> allResources() {
        return Collects.newHashSet(resource.getLocation());
    }
}
