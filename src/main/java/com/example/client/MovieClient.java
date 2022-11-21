package com.example.client;

import com.example.GenreRequest;
import com.example.MovieReply;
import com.example.MovieServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class MovieClient {
    public static void main(String[] args) {

        MovieClient movieClient = new MovieClient();
        movieClient.run();
    }

    private void run(){

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        unaryCall(channel);
    }
    private void unaryCall(ManagedChannel channel){

        MovieServiceGrpc.MovieServiceBlockingStub client = MovieServiceGrpc.newBlockingStub(channel);

        GenreRequest request = GenreRequest.newBuilder()
                .setGenre("Mystery")
                .build();

//        Client Stream:
//        MovieReply response = client.send(request);
//        System.out.println(response);

//        Server Stream :
        Iterator<MovieReply> response = client.send(request);
        for (int i = 1; response.hasNext(); i++) {
            System.out.println(response.next());
        }
    }
}

