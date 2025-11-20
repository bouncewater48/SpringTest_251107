package com.bounce.springtest.ajax;

import com.bounce.springtest.ajax.domain.Favorite;
import com.bounce.springtest.ajax.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<Favorite> getFavorite() {

        List<Favorite> favoriteList = favoriteRepository.selectFavorite();

        return favoriteList;
    }

}
