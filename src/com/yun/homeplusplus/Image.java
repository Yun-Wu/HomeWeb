package com.yun.homeplusplus;

@SuppressWarnings("deprecation")
public class Image {
        public double latitude;
        public double longitude;
        public byte[] physicalImage;

        public Image(double a, double b, byte[] c) {
                latitude = a;
                longitude = b;
                physicalImage = c;
        }

        public Image() {
        }
}
