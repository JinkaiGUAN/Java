package main.java.com.peter.entity;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/**
 * Copyright (C), Peter GUAN
 * FileName: Performance
 * Author:   Peter
 * Date:     08/04/2022 20:46
 * Description:
 * History:
 * Version:
 * @author Peter
 */
public interface Performance {
    public String getName();

    public Stream<Artist> getMusicians();

    // TODO: test
    public default Stream<Artist> getAllMusicians() {
        return getMusicians().flatMap(artist -> {
            return concat(Stream.of(artist), artist.getMembers());
        });
    }
}
