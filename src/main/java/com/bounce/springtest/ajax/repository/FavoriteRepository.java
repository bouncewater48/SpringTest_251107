package com.bounce.springtest.ajax.repository;

import com.bounce.springtest.ajax.domain.Favorite;

import java.util.List;

public interface FavoriteRepository {

    public List<Favorite> selectFavorite();

}
