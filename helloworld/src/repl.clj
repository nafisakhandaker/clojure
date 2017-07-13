(:requir 'cljs.repl)
(:requir 'cljs.build.api)
(:requir 'cljs.repl.browser)

(cljs.build.api/build "src"
                       {:main 'cljs helloworld.core
                        :output-to "out/main.js"
                        :verbose true})
 (cljs.repl/repl (cljs.reple.browser/repl-env)
                 :watch "src"
                 :output-dir "out"