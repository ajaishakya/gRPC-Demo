package com.example.server;

import com.example.endpoint.MovieEndpoint;
import io.grpc.BindableService;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptor;
import io.grpc.ServerTransportFilter;
import io.micronaut.grpc.server.GrpcServerBuilder;
import io.micronaut.grpc.server.GrpcServerConfiguration;
import jakarta.inject.Inject;

import java.util.List;

public class MovieServer extends GrpcServerBuilder {
    @Inject
    MovieEndpoint movieEndpoint;

    @Override
    protected ServerBuilder<?> serverBuilder(GrpcServerConfiguration configuration, List<BindableService> serviceList, List<ServerInterceptor> interceptors, List<ServerTransportFilter> serverTransportFilters) {
        return ServerBuilder.forPort(50051).addService(movieEndpoint);
    }
}


