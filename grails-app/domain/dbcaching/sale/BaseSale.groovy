package dbcaching.sale

import org.apache.commons.collections.FactoryUtils
import org.apache.commons.collections.ListUtils

abstract class BaseSale implements EmailableSale{

    Territory territory
    Date start
    Date end
    boolean active = false

    List translations = ListUtils.lazyList([], FactoryUtils.instantiateFactory(BaseSaleTranslation))

    static hasMany = [translations: BaseSaleTranslation]

    static mapping = {
        cache true
        translations cache: true
    }
}
