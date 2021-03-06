package com.albedo.java.test;


import net.devh.examples.grpc.lib.HelloReply;
import net.devh.examples.grpc.lib.HelloRequest;
import net.devh.examples.grpc.lib.SimpleGrpc;
import com.albedo.java.grpc.server.GrpcService;

import io.grpc.stub.StreamObserver;

/**
 * User: Michael
 * Email: yidongnan@gmail.com
 * Date: 2016/11/8
 */

@GrpcService(SimpleGrpc.class)
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello =============> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
