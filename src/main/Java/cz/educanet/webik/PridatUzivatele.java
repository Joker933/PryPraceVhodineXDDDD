public Response createUzivatel(@QueryParam("jmeno") String jmeno, @QueryParam("heslo") String heslo) {
        Uzivatel tempUzivatel = new Uzivatel(jmeno,heslo);
        if(doesUzivatelExist(tempUzivatel)){
        return Response.status(406).build();
        } else {
        names.add(tempUzivatel);
        return Response.ok("Uzivatel Created").build();
        }
}
