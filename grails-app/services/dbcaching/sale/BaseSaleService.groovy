package dbcaching.sale

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional
import org.grails.orm.hibernate.cfg.GrailsHibernateUtil

@Transactional
class BaseSaleService {

    @ReadOnly
    def getLatestSaleByUrlAndTerritory(String url, Territory territory) {
        log.info("================= START getLatestSaleByUrlAndTerritory  =================")
        def sales = BaseSale.createCriteria().list {
            cache true
            translations {
                eq('url', url)
            }
            eq("territory", territory)
            order('active', 'desc')
            order('start', 'desc')
        }
        log.info("Getting first sale")
        def res = sales ? sales.first() : null
        log.info("================= END getLatestSaleByUrlAndTerritory  =================")
        res
    }

    @ReadOnly
    BaseSale getBaseSale(Map params) {
        BaseSale baseSale = params.actualSaleId ? BaseSale.findById(params.actualSaleId, [cache: true]) :
                GrailsHibernateUtil.unwrapIfProxy(getLatestSaleByUrlAndTerritory(params.urlSlug, params.territory))
        return baseSale
    }
}
