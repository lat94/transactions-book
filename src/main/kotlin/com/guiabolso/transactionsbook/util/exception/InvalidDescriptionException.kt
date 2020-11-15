package com.guiabolso.transactionsbook.util.exception

import java.lang.RuntimeException

class InvalidDescriptionException: RuntimeException("description's length must be between 10 and 60")