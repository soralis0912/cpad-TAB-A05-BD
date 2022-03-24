/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tests.security;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import junit.framework.Assert;

public class AlgorithmParameterSymmetricHelper extends TestHelper<AlgorithmParameters> {

    private static final String plainData = "some data to encrypt and decrypt";
    private final String algorithmName;
    private final int keySize;
    private String blockmode;

    public AlgorithmParameterSymmetricHelper(String algorithmName, int keySize) {
        this.algorithmName = algorithmName;
        this.keySize = keySize;
    }

    public AlgorithmParameterSymmetricHelper(String algorithmName, String blockmode, int keySize) {
        this(algorithmName, keySize);
        this.blockmode = blockmode;
    }

    @Override
    public void test(AlgorithmParameters parameters) throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance(algorithmName);
        generator.init(keySize);

        Key key = generator.generateKey();
        String transformation = algorithmName;
        if (blockmode != null)
        {
            transformation += "/" + blockmode;
        }

        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, key, parameters);
        byte[] bs = cipher.doFinal(plainData.getBytes());

        cipher.init(Cipher.DECRYPT_MODE, key, parameters);
        byte[] decrypted = cipher.doFinal(bs);

        Assert.assertTrue(Arrays.equals(plainData.getBytes(), decrypted));
    }
}
