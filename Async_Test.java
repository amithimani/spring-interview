@Test
void testAsyncMethod() {
    assertTimeoutPreemptively(Duration.ofSeconds(5), () -> {
        CompletableFuture<String> futureResult = myService.asyncMethod();
        String result = futureResult.get();
        assertEquals("expected result", result);
    });
}


@Test
void testAsyncMethod() throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(1);
    myService.asyncMethod().thenAccept(result -> {
        assertEquals("expected result", result);
        latch.countDown();
    });
    latch.await();
}


@Test
void testAsyncMethod() throws Exception {
    CompletableFuture<String> futureResult = myService.asyncMethod();
    futureResult.thenAccept(result -> {
        assertEquals("expected result", result);
    });
    futureResult.get();
}
