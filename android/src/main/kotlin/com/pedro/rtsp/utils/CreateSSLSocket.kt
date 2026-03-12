/*
 * Based on the original CreateSSLSocket from Pedro's rtmp-rtsp-stream-client-java.
 * Provided alongside the fixed TLSSocketFactory to replace the versions in the
 * rtsp-2.0.7 AAR that hardcode TLSv1.1 (unsupported on Android API 33+).
 *
 * Original: https://github.com/pedroSG94/rtmp-rtsp-stream-client-java
 * Licensed under the Apache License, Version 2.0
 */

package com.pedro.rtsp.utils

import android.util.Log
import java.io.IOException
import java.net.Socket
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException

object CreateSSLSocket {

    @JvmStatic
    fun createSSlSocket(host: String, port: Int): Socket? {
        var socket: Socket? = null
        try {
            val factory = TLSSocketFactory()
            socket = factory.createSocket(host, port)
        } catch (e: NoSuchAlgorithmException) {
            Log.e("CreateSSLSocket", "Error", e)
            socket = null
        } catch (e: KeyManagementException) {
            Log.e("CreateSSLSocket", "Error", e)
            socket = null
        } catch (e: IOException) {
            Log.e("CreateSSLSocket", "Error", e)
            socket = null
        }
        return socket
    }
}
