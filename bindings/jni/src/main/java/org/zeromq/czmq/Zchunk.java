/*
################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Read the zproject/README.md for information about making permanent changes. #
################################################################################
*/
package org.zeromq.czmq;

import org.scijava.nativelib.NativeLoader;

public class Zchunk implements AutoCloseable{
    static {
        try {
            NativeLoader.loadLibrary("czmqjni");
        }
        catch (Exception e) {
            System.exit (-1);
        }
    }
    public long self;
    /*
    Create a new chunk of the specified size. If you specify the data, it
    is copied into the chunk. If you do not specify the data, the chunk is
    allocated and left empty, and you can then add data using zchunk_append.
    */
    native static long __new (byte [] data, long size);
    public Zchunk (byte [] data, long size) {
        /*  TODO: if __new fails, self is null...            */
        self = __new (data, size);
    }
    public Zchunk (long pointer) {
        self = pointer;
    }
    /*
    Destroy a chunk
    */
    native static void __destroy (long self);
    @Override
    public void close () {
        __destroy (self);
        self = 0;
    }
    /*
    Resizes chunk max_size as requested; chunk_cur size is set to zero
    */
    native static void __resize (long self, long size);
    public void resize (long size) {
        __resize (self, size);
    }
    /*
    Return chunk cur size
    */
    native static long __size (long self);
    public long size () {
        return __size (self);
    }
    /*
    Return chunk max size
    */
    native static long __maxSize (long self);
    public long maxSize () {
        return __maxSize (self);
    }
    /*
    Return chunk data
    */
    native static byte [] __data (long self);
    public byte [] data () {
        return __data (self);
    }
    /*
    Set chunk data from user-supplied data; truncate if too large. Data may
    be null. Returns actual size of chunk
    */
    native static long __set (long self, byte [] data, long size);
    public long set (byte [] data, long size) {
        return __set (self, data, size);
    }
    /*
    Fill chunk data from user-supplied octet
    */
    native static long __fill (long self, byte filler, long size);
    public long fill (byte filler, long size) {
        return __fill (self, filler, size);
    }
    /*
    Append user-supplied data to chunk, return resulting chunk size. If the
    data would exceeded the available space, it is truncated. If you want to
    grow the chunk to accommodate new data, use the zchunk_extend method.
    */
    native static long __append (long self, byte [] data, long size);
    public long append (byte [] data, long size) {
        return __append (self, data, size);
    }
    /*
    Append user-supplied data to chunk, return resulting chunk size. If the
    data would exceeded the available space, the chunk grows in size.
    */
    native static long __extend (long self, byte [] data, long size);
    public long extend (byte [] data, long size) {
        return __extend (self, data, size);
    }
    /*
    Copy as much data from 'source' into the chunk as possible; returns the
    new size of chunk. If all data from 'source' is used, returns exhausted
    on the source chunk. Source can be consumed as many times as needed until
    it is exhausted. If source was already exhausted, does not change chunk.
    */
    native static long __consume (long self, long source);
    public long consume (Zchunk source) {
        return __consume (self, source.self);
    }
    /*
    Returns true if the chunk was exhausted by consume methods, or if the
    chunk has a size of zero.
    */
    native static boolean __exhausted (long self);
    public boolean exhausted () {
        return __exhausted (self);
    }
    /*
    Try to slurp an entire file into a chunk. Will read up to maxsize of
    the file. If maxsize is 0, will attempt to read the entire file and
    fail with an assertion if that cannot fit into memory. Returns a new
    chunk containing the file data, or NULL if the file could not be read.
    */
    native static long __slurp (String filename, long maxsize);
    public static Zchunk slurp (String filename, long maxsize) {
        return new Zchunk (__slurp (filename, maxsize));
    }
    /*
    Create copy of chunk, as new chunk object. Returns a fresh zchunk_t
    object, or null if there was not enough heap memory. If chunk is null,
    returns null.
    */
    native static long __dup (long self);
    public Zchunk dup () {
        return new Zchunk (__dup (self));
    }
    /*
    Return chunk data encoded as printable hex string. Caller must free
    string when finished with it.
    */
    native static String __strhex (long self);
    public String strhex () {
        return __strhex (self);
    }
    /*
    Return chunk data copied into freshly allocated string
    Caller must free string when finished with it.
    */
    native static String __strdup (long self);
    public String strdup () {
        return __strdup (self);
    }
    /*
    Return TRUE if chunk body is equal to string, excluding terminator
    */
    native static boolean __streq (long self, String string);
    public boolean streq (String string) {
        return __streq (self, string);
    }
    /*
    Transform zchunk into a zframe that can be sent in a message.
    */
    native static long __pack (long self);
    public Zframe pack () {
        return new Zframe (__pack (self));
    }
    /*
    Transform a zframe into a zchunk.
    */
    native static long __unpack (long frame);
    public static Zchunk unpack (Zframe frame) {
        return new Zchunk (__unpack (frame.self));
    }
    /*
    Calculate SHA1 digest for chunk, using zdigest class.
    */
    native static String __digest (long self);
    public String digest () {
        return __digest (self);
    }
    /*
    Dump message to stderr, for debugging and tracing.
    See zchunk_fprint for details
    */
    native static void __print (long self);
    public void print () {
        __print (self);
    }
    /*
    Probe the supplied object, and report if it looks like a zchunk_t.
    */
    native static boolean __is (long self);
    public static boolean is (long self) {
        return __is (self);
    }
    /*
    Self test of this class.
    */
    native static void __test (boolean verbose);
    public static void test (boolean verbose) {
        __test (verbose);
    }
}
