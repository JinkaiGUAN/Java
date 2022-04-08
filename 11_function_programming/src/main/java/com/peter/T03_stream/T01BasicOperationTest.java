package main.java.com.peter.T03_stream;

import main.java.com.peter.entity.Track;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Copyright (C), Peter GUAN
 * FileName: T01_BasicOperation
 * Author:   Peter
 * Date:     08/04/2022 20:27
 * Description:
 * History:
 * Version:
 *
 * @author Peter
 */
public class T01BasicOperationTest {

    @Test
    public void testMaxMin() {
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));

        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();

        Assert.assertEquals(tracks.get(1), shortestTrack);
    }

    @Test
    public void testReduce() {
        int count = Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> acc + element);

        Assert.assertEquals(6, count);
    }



}
