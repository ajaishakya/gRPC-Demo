package com.example.logic;
import com.example.MovieDetail;
import com.example.MovieReply;
import com.example.MovieServiceGrpc;

import java.util.HashMap;
import java.util.Map;

public class MovieLogic extends MovieServiceGrpc.MovieServiceImplBase {

    public MovieReply response;
    public MovieLogic(String Genre) {

//        response = switch (Genre) {
//            case "Action" -> MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("AAA").setDescription("AAA")).
//                    addMovieDetail(MovieDetail.newBuilder().setName("AAA22").setDescription("AAA22")).setExtra("AAA333").build();
//            case "Comedy" -> MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("CCC").setDescription("CCC")).build();
//            case "Drama" -> MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("DDD").setDescription("DDD")).build();
//            case "Fantasy" -> MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("FFF").setDescription("FFF")).build();
//            case "Mystery" -> MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("MMMM").setDescription("MMM")).build();
//            default -> MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("Invalid")).build();
//        };


        Map<String, MovieReply> genre = new HashMap<>();
            genre.put("Action", MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("AAA111").setDescription("AAA111")).
                    addMovieDetail(MovieDetail.newBuilder().setName("AAA22").setDescription("AAA22")).setExtra("AAA333").build());
            genre.put("Comedy", MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("CCC111").setDescription("CCC222")).build());
            genre.put("Drama", MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("DDD111").setDescription("DDD222")).build());
            genre.put("Fantasy", MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("FFF1111").setDescription("FFF222")).build());
            genre.put("Mystery", MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("MMMM111").setDescription("MMM222")).build());

        genre.forEach((k, v) -> {
            if(k.equals(Genre)){
                response = v;
            }
        });

    }

}
