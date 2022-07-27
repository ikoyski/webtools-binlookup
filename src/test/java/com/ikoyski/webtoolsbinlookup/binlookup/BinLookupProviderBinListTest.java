package com.ikoyski.webtoolsbinlookup.binlookup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtoolsbinlookup.dto.BinLookupResponse;
import com.ikoyski.webtoolsbinlookup.provider.BinLookupProviderBaseInterface;
import com.ikoyski.webtoolsbinlookup.provider.BinLookupProviderFactory;

@SpringBootTest
class BinLookupProviderBinListTest {

	@Test
	@DisplayName("BinLookupProviderBinListTest.binLookupProviderBinListSuccess()")
	void binLookupProviderBinListSuccess() {
		// given
		final String BIN = "542458";
		BinLookupProviderFactory binLookupProviderFactory = new BinLookupProviderFactory();
		BinLookupProviderBaseInterface binLookupProvider = binLookupProviderFactory
				.createBinLookupProvider(BinLookupProviderFactory.PROVIDER_BINLIST);

		// when
		BinLookupResponse binLookupResponse = binLookupProvider.getBinInfo(BIN);

		// then
		Assertions.assertNotNull(binLookupResponse);
	}

	@Test
	@DisplayName("BinLookupProviderBinListTest.binLookupProviderBinListException()")
	void binLookupProviderBinListException() {
		// given
		final String BIN = "\\";
		BinLookupProviderFactory binLookupProviderFactory = new BinLookupProviderFactory();
		BinLookupProviderBaseInterface binLookupProvider = binLookupProviderFactory
				.createBinLookupProvider(BinLookupProviderFactory.PROVIDER_BINLIST);

		// when and then
		Assertions.assertThrows(Exception.class, () -> binLookupProvider.getBinInfo(BIN));
	}

}
