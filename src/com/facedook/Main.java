package com.facedook;

import com.facedook.page.Page;
import com.facedook.page.PageService;
import com.facedook.video.Video;
import com.facedook.video.VideoService;

public class Main {

    public static void main(String[] args) {
        final PageService pageService = new PageService();
        final VideoService videoService = new VideoService();

        // initialize data
        // create 3 pages
        final Page spaceXPage = pageService.create("SpaceX", "SpaceX designs, manufactures and launches the world’s most advanced rockets and spacecraft.");
        final Page teslaPage = pageService.create("Tesla", "Tesla manufactures electric cars, giant batteries and solar");
        final Page boringCompanyPage = pageService.create("Boring company");

        // add 3 videos + 1 video with invalid url
        final Video falconHeavyVideo = videoService.create("Falcon heavy launch", "https://www.youtube.com/watch?v=sB_nEtZxPog");
        final Video falcon9Video = videoService.create("Space X Falcon 9 CRS-11 Launch And Landing", "https://www.youtube.com/watch?v=ST76lGJ0UWA");
        final Video teslaEventVideo = videoService.create("Tesla Semi truck and Roadster event", "https://www.youtube.com/watch?v=5n9xafjynJA");
        final Video invalidVideo = videoService.create("Invalid url", "343456RTGEF4556DFGSDSFç)àà'(_èy");

        // manipulate data
        // follow pages
        for (int i = 0; i < 60; i++)
            pageService.follow(spaceXPage.getId());

        for (int i = 0; i < 45; i++)
            pageService.follow(teslaPage.getId());

        for (int i = 0; i < 30; i++)
            pageService.follow(boringCompanyPage.getId());

        for (int i = 0; i < 5; i++)
            pageService.unfollow(boringCompanyPage.getId());


        // like pages
        for (int i = 0; i < 20; i++)
            pageService.like(spaceXPage.getId());

        for (int i = 0; i < 15; i++)
            pageService.like(teslaPage.getId());

        for (int i = 0; i < 10; i++)
            pageService.like(boringCompanyPage.getId());

        for (int i = 0; i < 3; i++)
            pageService.dislike(boringCompanyPage.getId());


        // like videos
        for (int i = 0; i < 50; i++)
            videoService.like(falconHeavyVideo.getId());

        for (int i = 0; i < 30; i++)
            videoService.like(falcon9Video.getId());

        for (int i = 0; i < 25; i++)
            videoService.like(teslaEventVideo.getId());

        for (int i = 0; i < 2; i++)
            videoService.dislike(teslaEventVideo.getId());


        // show results
        pageService.findAll()
                .forEach((id, page) -> {
                    System.out.println("------- Page ---------");
                    System.out.println(page);
                });

        videoService.findAll()
                .forEach((id, video) -> {
                    System.out.println("------- Video ---------");
                    System.out.println(video);
                });


    }
}
