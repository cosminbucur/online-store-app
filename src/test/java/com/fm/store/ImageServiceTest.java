package com.fm.store;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ImageServiceTest {

    @Test
    void whenLoadImage_shouldReturnByteArray() {
        ImageService imageService = new ImageService();

//        byte[] actual = imageService.loadImage("/home/cosbuc/dev/freeminions/online-store/src/main/resources/images/laptop.jpeg");
//        byte[] actual = imageService.loadImage("/images/laptop.jpeg");
        byte[] actual = imageService.loadImage2("images/laptop.jpeg");

        assertThat(actual).isNotEmpty();
    }
}