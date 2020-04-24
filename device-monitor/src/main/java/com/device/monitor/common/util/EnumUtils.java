package com.device.monitor.common.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.StringUtils;

import com.device.monitor.common.enums.CodeValueEnum;
import com.device.monitor.common.enums.DescriptionEnum;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EnumUtils {
	
    /**
     * <p>[功能描述]：据编码查询枚举对象</p>
     *
     * @author 赵 娜, 2020年03月19日
     * @since  卓朗科技 系统集成部
     *
     * @param enumClass
     * @param code
     * @return
     */
    public static <T extends Enum<T> & CodeValueEnum> T enumOfCode(Class<T> enumClass, Integer code) {
        if (enumClass == null || code == null) {
            return null;
        }
        T[] enumConstants = enumClass.getEnumConstants();
        return Stream.of(enumConstants)
                .filter(e -> e.code() == code)
                .findFirst()
                .orElse(null);
    }

    /**
     * <p>[功能描述]：根据编码查询文字描述</p>
     *
     * @author 赵 娜, 2020年03月19日
     * @since  卓朗科技 系统集成部
     *
     * @param enumClass
     * @param code
     * @return
     */
    public static <T extends Enum<T> & CodeValueEnum & DescriptionEnum> String descOfCode(
            Class<T> enumClass, Integer code) {
        if (enumClass == null || code == null) {
            return null;
        }
        T[] enumConstants = enumClass.getEnumConstants();
        return Stream.of(enumConstants)
                .filter(e -> e.code() == code)
                .map(o -> o.description())
                .findFirst()
                .orElse(null);
    }
    
    /**
     * <p>[功能描述]：根据文字描述查询编码</p>
     *
     * @author 赵 娜, 2020年03月19日
     * @since  卓朗科技 系统集成部
     *
     * @param enumClass
     * @param description
     * @return
     */
    public static <T extends Enum<T> & CodeValueEnum & DescriptionEnum> Integer codeOfDesc(
            Class<T> enumClass, String description) {
        if (enumClass == null || StringUtils.isEmpty(description)) {
            return null;
        }
        T[] enumConstants = enumClass.getEnumConstants();
        return Stream.of(enumConstants)
                .filter(e -> e.description().equals(description))
                .map(o -> o.code())
                .findFirst()
                .orElse(null);
    }

    /**
     * <p>[功能描述]：根据编码列表查询文字描述列表，分隔符分隔</p>
     *
     * @author 赵 娜, 2020年03月19日
     * @since  卓朗科技 系统集成部
     *
     * @param enumClass
     * @param codes
     * @param separator
     * @return
     */
    public static <T extends Enum<T> & CodeValueEnum & DescriptionEnum> String descsOfCodes(
            Class<T> enumClass, List<Integer> codes, String separator) {
        if (enumClass == null || codes == null) {
            return null;
        }
        T[] enumConstants = enumClass.getEnumConstants();
        return Stream.of(enumConstants)
                .filter(e -> codes.contains(e.code()))
                .map(o -> o.description())
                .collect(Collectors.joining(separator));
    }

    /**
     * <p>[功能描述]：查询最大值</p>
     *
     * @author 赵 娜, 2020年03月19日
     * @since  卓朗科技 系统集成部
     *
     * @param enumClass
     * @return
     */
    public static <T extends Enum<T> & CodeValueEnum> Integer maxValue(Class<T> enumClass) {
        if (enumClass == null) {
            return null;
        }
        T[] enumConstants = enumClass.getEnumConstants();
        return Stream.of(enumConstants).map(o -> o.code()).reduce(Integer::max).get();
    }
}
