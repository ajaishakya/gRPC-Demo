package com.example.endpoint;

import com.example.*;
import io.grpc.stub.StreamObserver;
import jakarta.inject.Singleton;
import com.example.logic.MovieLogic;

import java.util.*;

@Singleton
public class MovieEndpoint extends MovieServiceGrpc.MovieServiceImplBase {
    @Override
    public void send(GenreRequest request, StreamObserver<MovieReply> responseObserver) {

        String Genre = request.getGenre();
        MovieLogic ml = new MovieLogic(Genre);

        for (int i=1; i<=5; i++){
            responseObserver.onNext(ml.response);
        }
        responseObserver.onCompleted();
    }
}



//        Map<String, String> genre = new HashMap<>();
//        genre.put("Action", "Great Gatsby");
//        genre.put("Comedy", "To Kill MockingBird");
//        genre.put("Drama", "Passage to India");
//        genre.put("Fantasy", "The Side of Paradise");
//        genre.put("Mystery", "Go Set a Watchman");
//
//        genre.forEach((k, v) -> {
//
//        });
//
//        var set=genre.entrySet();
//        var itr = set.iterator();
//        while(itr.hasNext()) {
//            Map.Entry<String, String> m = itr.next();
//            if(m.getKey() == Genre){
//                String ab = String.valueOf(m.getValue());
//                MovieReply reply = MovieReply.newBuilder().setMovie(ab).build();
//                responseObserver.onNext(reply);
//                responseObserver.onCompleted();
//            }
//        }


// LOGIC ONE
//        for(Map.Entry m:genre.entrySet()){
//            if(m.getKey()==Genre){
//                String ab = String.valueOf(m.getValue());
//                MovieReply reply = MovieReply.newBuilder().setMovie(ab).build();
//                responseObserver.onNext(reply);
//                responseObserver.onCompleted();
//            }
//        }
//                }
//                }

//          ************ This is the runnable one *************
//        MovieReply response = switch (Genre) {
//            case "Action" -> MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("AAA").setDescription("AAA")).
//                    addMovieDetail(MovieDetail.newBuilder().setName("AAA22").setDescription("AAA22")).setExtra("AAA333").build();
//            case "Comedy" -> MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("CCC").setDescription("CCC")).build();
//            case "Drama" -> MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("DDD").setDescription("DDD")).build();
//            case "Fantasy" -> MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("FFF").setDescription("FFF")).build();
//            case "Mystery" -> MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("MMMM").setDescription("MMM")).build();
//            default -> MovieReply.newBuilder().addMovieDetail(MovieDetail.newBuilder().setName("Invalid")).build();
//        };

//        MovieReply response = switch (Genre) {
//            case "Action" -> MovieReply.newBuilder().setName("AAA").setDescription("AAA").build();
//            case "Comedy" -> MovieReply.newBuilder().setName("CCC").setDescription("CCC").build();
//            case "Drama" -> MovieReply.newBuilder().setName("DDD").setDescription("DDD").build();
//            case "Fantasy" -> MovieReply.newBuilder().setName("FFF").setDescription("FFF").build();
//            case "Mystery" -> MovieReply.newBuilder().setName("MMMM").setDescription("MMM").build();
//            default -> MovieReply.newBuilder().setName("Invalid").build();
//        };





