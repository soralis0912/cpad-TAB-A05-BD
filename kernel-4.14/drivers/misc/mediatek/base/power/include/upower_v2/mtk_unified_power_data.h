/*
 * Copyright (C) 2016 MediaTek Inc.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as
 * published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See http://www.gnu.org/licenses/gpl-2.0.html for more details.
 */
#ifndef MTK_UNIFIED_POWER_DATA_H
#define MTK_UNIFIED_POWER_DATA_H

#if defined(CONFIG_MACH_MT6759)
#include "mtk_unified_power_data_mt6759.h"
#endif

#if defined(CONFIG_MACH_MT6763)
#include "mtk_unified_power_data_mt6763.h"
#endif

#if defined(CONFIG_MACH_MT6758)
#include "mtk_unified_power_data_mt6758.h"
#endif

#if defined(CONFIG_MACH_MT6739)
#include "mtk_unified_power_data_mt6739.h"
#endif

#if defined(CONFIG_MACH_MT6771)
#include "mtk_unified_power_data_mt6771.h"
#endif

#if defined(CONFIG_MACH_MT6775)
#include "mtk_unified_power_data_mt6775.h"
#endif

#if defined(CONFIG_MACH_MT8168)
#include "mtk_unified_power_data_mt8168.h"
#endif

#endif /* UNIFIED_POWER_DATA_H */
