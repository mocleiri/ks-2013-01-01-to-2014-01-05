package com.sigmasys.kuali.ksa.service;

import com.sigmasys.kuali.ksa.model.KeyPair;
import com.sigmasys.kuali.ksa.model.KeyPairAware;

import java.util.List;

/**
 * This interface defines basic operations on KeyPair objects.
 * KeyPairAware has to be persistent if there is a need to propagate changes to the persistent store.
 * <p/>
 *
 * @author Michael Ivanov
 */
public interface KeyPairService {

    KeyPairAware addKeyPairs(KeyPairAware entity, List<KeyPair> keyPairs);

    KeyPairAware addKeyPairs(KeyPairAware entity, KeyPair... keyPairs);

    KeyPairAware removeKeyPairs(KeyPairAware entity, List<Long> keyPairIds);

    KeyPairAware removeKeyPairs(KeyPairAware entity, Long... keyPairIds);

    KeyPairAware removeKeyPairsByKeys(KeyPairAware entity, List<String> keys);

    KeyPairAware removeKeyPairsByKeys(KeyPairAware entity, String... keys);

    KeyPairAware updateKeyPair(KeyPairAware entity, Long keyPairId, String key, String value);

}
