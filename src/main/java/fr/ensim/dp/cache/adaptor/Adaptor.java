package fr.ensim.dp.cache.adaptor;

import fr.ensim.dp.cache.ICache;
import org.jdesktop.swingx.mapviewer.TileCache;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;

public class Adaptor extends TileCache {

    private ICache cache;

    public Adaptor(ICache cache) {
        this.cache = cache;
    }

    @Override
    public void put(URI uri, byte[] bimg, BufferedImage img) {
        cache.add(uri.toString(), bimg);
    }

    @Override
    public BufferedImage get(URI uri) throws IOException {
        byte[] bimg = cache.retreive(uri.toString());
        try {
            return ImageIO.read(new ByteArrayInputStream(bimg));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void needMoreMemory() {
        cache.clear();
    }
}
