package com.hoangha.jpaservlet.filter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.*;

public class CharResponseWrapper extends HttpServletResponseWrapper {

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private PrintWriter printWriter;
    private ServletOutputStream servletOutputStream;

    public CharResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (printWriter == null) {
            printWriter = new PrintWriter(new OutputStreamWriter(byteArrayOutputStream, getCharacterEncoding()), true);
        }
        return printWriter;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (servletOutputStream == null) {
            servletOutputStream = new ServletOutputStream() {
                @Override
                public void write(int b) throws IOException {
                    byteArrayOutputStream.write(b);
                }

                @Override
                public boolean isReady() {
                    return true;
                }

                @Override
                public void setWriteListener(WriteListener writeListener) {
                    // Không dùng trong ví dụ này
                }
            };
        }
        return servletOutputStream;
    }

    @Override
    public void flushBuffer() throws IOException {
        if (printWriter != null) {
            printWriter.flush();
        }
        if (servletOutputStream != null) {
            servletOutputStream.flush();
        }
    }

    @Override
    public String toString() {
        try {
            flushBuffer();
            return byteArrayOutputStream.toString(getCharacterEncoding());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}