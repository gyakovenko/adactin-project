package com.sqa.gy.misc;

import java.text.*;
import java.util.*;

import org.testng.annotations.*;

public class dateTest {
	@Test
	public void f() {
		Calendar calPlus7 = Calendar.getInstance();
		calPlus7.add(Calendar.DAY_OF_MONTH, 7);
		Date todayPlusSeven = calPlus7.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(sdf.format(todayPlusSeven));
	}
}
