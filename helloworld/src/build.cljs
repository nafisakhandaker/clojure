(:requir 'cljs.build.api)


(cljs.build.api/build "src"
                       {:main 'cljs helloworld.core
                        :output-to "out/main.js"})
 