/**
 * Copyright 2011-2014 the original author or authors.
 */
package com.jetdrone.vertx.yoke.middleware;

import com.jetdrone.vertx.yoke.Middleware;
import com.jetdrone.vertx.yoke.annotations.*;
import groovy.lang.Closure;
import org.vertx.java.core.Handler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class GRouter extends Middleware {

    private final Router jRouter = new Router();

    @Override
    public void handle(YokeRequest request, Handler<Object> next) {
        jRouter.handle(request, next);
    }

    private static Middleware wrapClosure(final Closure closure) {
        final int params = closure.getMaximumNumberOfParameters();
        return new Middleware() {
            @Override
            public void handle(YokeRequest request, Handler<Object> next) {
                if (params == 1) {
                    closure.call(request);
                } else if (params == 2) {
                    closure.call(request, next);
                } else {
                    throw new RuntimeException("Cannot infer the closure signature, should be: request [, next]");
                }
            }
        };
    }

    /**
     * Specify a middleware that will be called for a matching HTTP GET
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter get(String pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.get(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP PUT
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter put(String pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.put(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP POST
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter post(String pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.post(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP DELETE
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter delete(String pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.delete(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP OPTIONS
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter options(String pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.options(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP HEAD
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter head(String pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.head(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP TRACE
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter trace(String pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.trace(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP CONNECT
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter connect(String pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.trace(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP PATCH
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter patch(String pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.trace(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for all HTTP methods
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter all(String pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.all(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP GET
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter get(Pattern pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.get(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP PUT
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter put(Pattern pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.put(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP POST
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter post(Pattern pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.post(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP DELETE
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter delete(Pattern pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.delete(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP OPTIONS
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter options(Pattern pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.options(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP HEAD
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter head(Pattern pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.head(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP TRACE
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter trace(Pattern pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.trace(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP CONNECT
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter connect(Pattern pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.trace(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for a matching HTTP PATCH
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter patch(Pattern pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.trace(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for all HTTP methods
     * @param pattern The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter all(Pattern pattern, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.all(pattern, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for all HTTP methods
     * @param param The simple pattern
     * @param handlers The middleware to call
     */
    public GRouter param(String param, Closure... handlers) {
        for (Closure handler : handlers) {
            jRouter.param(param, wrapClosure(handler));
        }
        return this;
    }

    /**
     * Specify a middleware that will be called for all HTTP methods
     * @param param The simple pattern
     * @param pattern The RegExp to validate the param
     */
    public GRouter param(String param, Pattern pattern) {
        jRouter.param(param, pattern);
        return this;
    }

    private static String getPath(Object o, Field f) {
        // read the closure one
        Path p = f.getAnnotation(Path.class);
        if (p != null) {
            // method path is present
            return p.value();
        }

        p = o.getClass().getAnnotation(Path.class);
        if (p != null) {
            // top level path is present
            return p.value();
        }
        throw new RuntimeException("Cannot infer the path for this Closure");
    }

    private static Middleware wrapClosure(final Closure closure, final String[] consumes, final String[] produces) {
        final int params = closure.getMaximumNumberOfParameters();
        return new Middleware() {
            @Override
            public void handle(YokeRequest request, Handler<Object> next) {
                // we only know how to process certain media types
                if (consumes != null) {
                    boolean canConsume = false;
                    for (String c : consumes) {
                        if (request.is(c)) {
                            canConsume = true;
                            break;
                        }
                    }

                    if (!canConsume) {
                        // 415 Unsupported Media Type (we don't know how to handle this media)
                        next.handle(415);
                        return;
                    }
                }

                // the object was marked with a specific content type
                if (produces != null) {
                    String bestContentType = request.accepts(produces);

                    // the client does not know how to handle our content type, return 406
                    if (bestContentType == null) {
                        next.handle(406);
                        return;
                    }

                    // mark the response with the correct content type (which allows middleware to know it later on)
                    request.response().setContentType(bestContentType);
                }
                if (params == 1) {
                    closure.call(request);
                } else if (params == 2) {
                    closure.call(request, next);
                } else {
                    throw new RuntimeException("Cannot infer the closure signature, should be: request [, next]");
                }
            }
        };
    }

    /**
     * Builds a Router from an annotated Java Object
     */
    public static GRouter from(Object... objs) {

        GRouter router = new GRouter();

        for (Object o : objs) {
            for (final Field f : o.getClass().getFields()) {
                Annotation[] annotations = f.getAnnotations();
                // this method is not annotated
                if (annotations == null) {
                    continue;
                }

                if (!Closure.class.equals(f.getType())) {
                    continue;
                }

                Closure closure;

                try {
                    closure = (Closure) f.get(o);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

                String path = getPath(o, f);

                String[] produces = null;
                String[] consumes = null;

                // identify produces/consumes for content negotiation
                for (Annotation a : annotations) {
                    if (a instanceof Consumes) {
                        consumes = ((Consumes) a).value();
                    }
                    if (a instanceof Produces) {
                        produces = ((Produces) a).value();
                    }
                }

                // if still null inspect class
                if (consumes == null) {
                    Annotation c = o.getClass().getAnnotation(Consumes.class);
                    if (c != null) {
                        // top level consumes is present
                        consumes = ((Consumes) c).value();
                    }
                }

                if (produces == null) {
                    Annotation p = o.getClass().getAnnotation(Produces.class);
                    if (p != null) {
                        // top level consumes is present
                        produces = ((Produces) p).value();
                    }
                }

                for (Annotation a : annotations) {
                    if (a instanceof GET) {
                        router.jRouter.get(path, wrapClosure(closure, consumes, produces));
                    }
                    if (a instanceof PUT) {
                        router.jRouter.put(path, wrapClosure(closure, consumes, produces));
                    }
                    if (a instanceof POST) {
                        router.jRouter.post(path, wrapClosure(closure, consumes, produces));
                    }
                    if (a instanceof DELETE) {
                        router.jRouter.delete(path, wrapClosure(closure, consumes, produces));
                    }
                    if (a instanceof OPTIONS) {
                        router.jRouter.options(path, wrapClosure(closure, consumes, produces));
                    }
                    if (a instanceof HEAD) {
                        router.jRouter.head(path, wrapClosure(closure, consumes, produces));
                    }
                    if (a instanceof TRACE) {
                        router.jRouter.trace(path, wrapClosure(closure, consumes, produces));
                    }
                    if (a instanceof PATCH) {
                        router.jRouter.patch(path, wrapClosure(closure, consumes, produces));
                    }
                    if (a instanceof CONNECT) {
                        router.jRouter.connect(path, wrapClosure(closure, consumes, produces));
                    }
                    if (a instanceof ALL) {
                        router.jRouter.all(path, wrapClosure(closure, consumes, produces));
                    }
                }
            }
        }

        return router;
    }
}
