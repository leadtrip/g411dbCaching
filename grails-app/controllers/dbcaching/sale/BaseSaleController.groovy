package dbcaching.sale

import grails.gorm.transactions.ReadOnly

class BaseSaleController {

    def baseSaleService

    def index() {
        [baseSale: baseSale]
    }

    protected BaseSale getBaseSale() {
        params.urlSlug = 'bs1url'
        return baseSaleService.getBaseSale(urlSlug: params.urlSlug, territory: territory, actualSaleId: params.long('actualSaleId'))
    }

    @ReadOnly
    def getTerritory() {
        if ( !session.territory ) {
            session.territory = Territory.findByName('terr1')
        }
        session.territory
    }
}
