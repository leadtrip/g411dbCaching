package dbcaching.sale

class HotelSale extends BaseSale{

/*    static mapping = {
        cache true
    }*/

    @Override
    String getTitle() {
        return 'hotel sale title'
    }
}
