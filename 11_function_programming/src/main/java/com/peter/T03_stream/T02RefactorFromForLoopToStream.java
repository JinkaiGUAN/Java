package main.java.com.peter.T03_stream;

import main.java.com.peter.entity.Album;
import main.java.com.peter.entity.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright (C), Peter GUAN
 * FileName: T01RefactorFromForLoopToStream
 * Author:   Peter
 * Date:     08/04/2022 20:53
 * Description: 重构for循环代码为Stream
 * History:
 * Version:
 * @author Peter
 */
public class T02RefactorFromForLoopToStream {

    public static interface LongTrackFinder {
        public Set<String> findLongTracks(List<Album> albums);
    }

    public static class Step0 implements LongTrackFinder {

        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            for (Album album : albums) {
                for (Track track : album.getTrackList()) {
                    if (track.getLength() > 60) {
                        trackNames.add(track.getName());
                    }
                }
            }
            return trackNames;
        }
    }

}
