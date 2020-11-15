package com.guiabolso.transactionsbook.util.exception

import java.lang.RuntimeException

class InvalidValueException: RuntimeException("value must be between -9999999 and 9999999")