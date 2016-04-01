package sample.webservices.EbayServer.src.ebay.server;
import javax.jws.WebService;
import javax.xml.ws.*;
import ebay.apis.*;
import java.util.HashMap;
import java.util.Map;

@WebService(serviceName = "eBayAPIInterfaceService", portName = "eBayAPI", endpointInterface = "ebay.apis.EBayAPIInterface", targetNamespace = "urn:ebay:apis:eBLBaseComponents", wsdlLocation = "META-INF/wsdl/eBaySvc.wsdl")
public class Ebay implements EBayAPIInterface {

    private Map<String, ItemType> items;

    public Ebay () {
        items = new HashMap<String, ItemType>();
        ItemType item = new ItemType();
        item.setItemID("9720685987");
        item.setDescription("New Sun Blade 1000 (dual 750Mhz 8MB cache/4GB ram/DVD/2x36)");
        item.setTitle("Sun Blade 1000 (dual 750Mhz 8MB cache/4GB ram/DVD/2x36)");
        AmountType amount = new AmountType();
        amount.setValue(1975.99);
        amount.setCurrencyID(CurrencyCodeType.USD);
        item.setBuyItNowPrice(amount);
        PictureDetailsType picDetails = new PictureDetailsType();
        picDetails.setGalleryURL("http://localhost:7070/ImageProvider/sun_blade_1000_h400px.jpg");
        item.setPictureDetails(picDetails);
        items.put(item.getItemID(), item);
        items.put("1", item);

        item = new ItemType();
        item.setItemID("9723025228");
        item.setDescription("Sun Enterprise E15K Server (Sun E15K)72x900MHz, 144GB");
        item.setTitle("Sun Enterprise E15K Server (Sun E15K) 72x900MHz,144GB");
        amount = new AmountType();
        amount.setValue(99500.00 );
        amount.setCurrencyID(CurrencyCodeType.USD);
        item.setBuyItNowPrice(amount);
        picDetails = new PictureDetailsType();
        picDetails.setGalleryURL("http://localhost:7070/ImageProvider/Sun_Fire_E20K_Server.jpg");
        item.setPictureDetails(picDetails);
        items.put(item.getItemID(), item);
        items.put("2", item);

        item = new ItemType();
        item.setItemID("9722594617");
        item.setDescription("SUN Blade 150 / A41-UTA19C512MDL/650MHz/512MB/80GB/DVD");
        item.setTitle("SUN Blade 150 / A41-UTA19C512MDL/650MHz/512MB/80GB/DVD");
        amount = new AmountType();
        amount.setValue(1095.00);
        amount.setCurrencyID(CurrencyCodeType.USD);
        item.setBuyItNowPrice(amount);
        picDetails = new PictureDetailsType();
        picDetails.setGalleryURL("http://localhost:7070/ImageProvider/8d_2.jpg");
        item.setPictureDetails(picDetails);
        items.put(item.getItemID(), item);
        items.put("3", item);
    }

    public AddDisputeResponseType addDispute(AddDisputeRequestType
                                             addDisputeRequest)
    {
        return null;
    }

    public AddDisputeResponseResponseType addDisputeResponse(AddDisputeResponseRequestType addDisputeResponseRequest) {
        return null;
    }

    public AddItemResponseType
addItem(AddItemRequestType addItemRequest)
{
        return null;
    }

    public AddLiveAuctionItemResponseType
addLiveAuctionItem(AddLiveAuctionItemRequestType
addLiveAuctionItemRequest) {
        return null;
    }

    public AddMemberMessageResponseType
addMemberMessage(AddMemberMessageRequestType
addMemberMessageRequest) {
        return null;
    }

    public
AddMemberMessagesAAQToBidderResponseType
addMemberMessagesAAQToBidder(AddMemberMessagesAAQToBidderRequestType
addMemberMessagesAAQToBidderRequest) {
        return null;
    }

    public AddOrderResponseType
addOrder(AddOrderRequestType
addOrderRequest) {
        return null;
    }

    public AddSecondChanceItemResponseType
addSecondChanceItem(AddSecondChanceItemRequestType
addSecondChanceItemRequest) {
        return null;
    }

    public AddToItemDescriptionResponseType
addToItemDescription(AddToItemDescriptionRequestType
addToItemDescriptionRequest) {
        return null;
    }

    public AddToWatchListResponseType
addToWatchList(AddToWatchListRequestType
addToWatchListRequest) {
        return null;
    }

    public
ApproveLiveAuctionBiddersResponseType
approveLiveAuctionBidders(ApproveLiveAuctionBiddersRequestType
approveLiveAuctionBiddersRequest) {
        return null;
    }

    public CompleteSaleResponseType
completeSale(CompleteSaleRequestType
completeSaleRequest) {
        return null;
    }

    public DeleteMyMessagesResponseType
deleteMyMessages(DeleteMyMessagesRequestType
deleteMyMessagesRequest) {
        return null;
    }

    public EndItemResponseType
endItem(EndItemRequestType endItemRequest)
{
        return null;
    }

    public FetchTokenResponseType
fetchToken(FetchTokenRequestType
fetchTokenRequest) {
        return null;
    }

    public GetAccountResponseType
getAccount(GetAccountRequestType
getAccountRequest) {
        return null;
    }

    public GetAdFormatLeadsResponseType
getAdFormatLeads(GetAdFormatLeadsRequestType
getAdFormatLeadsRequest) {
        return null;
    }

    public GetAllBiddersResponseType
getAllBidders(GetAllBiddersRequestType
getAllBiddersRequest) {
        return null;
    }

    public GetApiAccessRulesResponseType
getApiAccessRules(GetApiAccessRulesRequestType
getApiAccessRulesRequest) {
        return null;
    }

    public GetAttributesCSResponseType
getAttributesCS(GetAttributesCSRequestType
getAttributesCSRequest) {
        return null;
    }

    public GetAttributesXSLResponseType
getAttributesXSL(GetAttributesXSLRequestType
getAttributesXSLRequest) {
        return null;
    }

    public GetBestOffersResponseType
getBestOffers(GetBestOffersRequestType
getBestOffersRequest) {
        return null;
    }

    public GetBidderListResponseType
getBidderList(GetBidderListRequestType
getBidderListRequest) {
        return null;
    }

    public GetCategoriesResponseType
getCategories(GetCategoriesRequestType
getCategoriesRequest) {
        return null;
    }

    public GetCategory2CSResponseType
getCategory2CS(GetCategory2CSRequestType
getCategory2CSRequest) {
        return null;
    }

    public
GetCategory2FinanceOfferResponseType
getCategory2FinanceOffer(GetCategory2FinanceOfferRequestType
getCategory2FinanceOfferRequest) {
        return null;
    }

    public GetCategoryFeaturesResponseType
getCategoryFeatures(GetCategoryFeaturesRequestType
getCategoryFeaturesRequest) {
        return null;
    }

    public GetCategoryListingsResponseType
getCategoryListings(GetCategoryListingsRequestType
getCategoryListingsRequest) {
        return null;
    }

    public GetCategoryMappingsResponseType
getCategoryMappings(GetCategoryMappingsRequestType
getCategoryMappingsRequest) {
        return null;
    }

    public GetCharitiesResponseType
getCharities(GetCharitiesRequestType
getCharitiesRequest) {
        return null;
    }

    public GetCrossPromotionsResponseType
getCrossPromotions(GetCrossPromotionsRequestType
getCrossPromotionsRequest) {
        return null;
    }

    public
GetDescriptionTemplatesResponseType
getDescriptionTemplates(GetDescriptionTemplatesRequestType
getDescriptionTemplatesRequest) {
        return null;
    }

    public GetDisputeResponseType
getDispute(GetDisputeRequestType
getDisputeRequest) {
        return null;
    }

    public GetFeedbackResponseType
getFeedback(GetFeedbackRequestType
getFeedbackRequest) {
        return null;
    }

    public GetFinanceOffersResponseType
getFinanceOffers(GetFinanceOffersRequestType
getFinanceOffersRequest) {
        return null;
    }

    public GetHighBiddersResponseType
getHighBidders(GetHighBiddersRequestType
getHighBiddersRequest) {
        return null;
    }

    public GetItemResponseType
getItem(GetItemRequestType getItemRequest)
{
        GetItemResponseType response = new GetItemResponseType();
//        ItemType item = items.get("9720685987");
        ItemType item = items.get(getItemRequest.getItemID());
        response.setItem(item);
        return response;
    }

    public
GetItemRecommendationsResponseType
getItemRecommendations(GetItemRecommendationsRequestType
getItemRecommendationsRequest) {
        return null;
    }

    public GetItemShippingResponseType
getItemShipping(GetItemShippingRequestType
getItemShippingRequest) {
        return null;
    }

    public GetItemTransactionsResponseType
getItemTransactions(GetItemTransactionsRequestType
getItemTransactionsRequest) {
        return null;
    }

    public
GetItemsAwaitingFeedbackResponseType
getItemsAwaitingFeedback(GetItemsAwaitingFeedbackRequestType
getItemsAwaitingFeedbackRequest) {
        return null;
    }

    public
GetLiveAuctionBiddersResponseType
getLiveAuctionBidders(GetLiveAuctionBiddersRequestType
getLiveAuctionBiddersRequest) {
        return null;
    }

    public
GetLiveAuctionCatalogDetailsResponseType
getLiveAuctionCatalogDetails(GetLiveAuctionCatalogDetailsRequestType
getLiveAuctionCatalogDetailsRequest) {
        return null;
    }

    public GetMemberMessagesResponseType
getMemberMessages(GetMemberMessagesRequestType
getMemberMessagesRequest) {
        return null;
    }

    public GetMyMessagesResponseType
getMyMessages(GetMyMessagesRequestType
getMyMessagesRequest) {
        return null;
    }

    public GetMyeBayResponseType
getMyeBay(GetMyeBayRequestType
getMyeBayRequest) {
        return null;
    }

    public GetMyeBayBuyingResponseType
getMyeBayBuying(GetMyeBayBuyingRequestType
getMyeBayBuyingRequest) {
        return null;
    }

    public GetMyeBayRemindersResponseType
getMyeBayReminders(GetMyeBayRemindersRequestType
getMyeBayRemindersRequest) {
        return null;
    }

    public GetMyeBaySellingResponseType
getMyeBaySelling(GetMyeBaySellingRequestType
getMyeBaySellingRequest) {
        return null;
    }

    public
GetNotificationPreferencesResponseType
getNotificationPreferences(GetNotificationPreferencesRequestType
getNotificationPreferencesRequest) {
        return null;
    }

    public
GetNotificationsUsageResponseType
getNotificationsUsage(GetNotificationsUsageRequestType
getNotificationsUsageRequest) {
        return null;
    }

    public GetOrderTransactionsResponseType
getOrderTransactions(GetOrderTransactionsRequestType
getOrderTransactionsRequest) {
        return null;
    }

    public GetOrdersResponseType
getOrders(GetOrdersRequestType
getOrdersRequest) {
        return null;
    }

    public
GetPictureManagerDetailsResponseType
getPictureManagerDetails(GetPictureManagerDetailsRequestType
getPictureManagerDetailsRequest) {
        return null;
    }

    public
GetPictureManagerOptionsResponseType
getPictureManagerOptions(GetPictureManagerOptionsRequestType
getPictureManagerOptionsRequest) {
        return null;
    }

    public GetPopularKeywordsResponseType
getPopularKeywords(GetPopularKeywordsRequestType
getPopularKeywordsRequest) {
        return null;
    }

    public
GetProductFamilyMembersResponseType
getProductFamilyMembers(GetProductFamilyMembersRequestType
getProductFamilyMembersRequest) {
        return null;
    }

    public GetProductFinderResponseType
getProductFinder(GetProductFinderRequestType
getProductFinderRequest) {
        return null;
    }

    public GetProductFinderXSLResponseType
getProductFinderXSL(GetProductFinderXSLRequestType
getProductFinderXSLRequest) {
        return null;
    }

    public GetProductSearchPageResponseType
getProductSearchPage(GetProductSearchPageRequestType
getProductSearchPageRequest) {
        return null;
    }

    public
GetProductSearchResultsResponseType
getProductSearchResults(GetProductSearchResultsRequestType
getProductSearchResultsRequest) {
        return null;
    }

    public
GetProductSellingPagesResponseType
getProductSellingPages(GetProductSellingPagesRequestType
getProductSellingPagesRequest) {
        return null;
    }

    public GetPromotionRulesResponseType
getPromotionRules(GetPromotionRulesRequestType
getPromotionRulesRequest) {
        return null;
    }

    public GetRecommendationsResponseType
getRecommendations(GetRecommendationsRequestType
getRecommendationsRequest) {
        return null;
    }

    public GetReturnURLResponseType
getReturnURL(GetReturnURLRequestType
getReturnURLRequest) {
        return null;
    }

    public GetRuNameResponseType
getRuName(GetRuNameRequestType
getRuNameRequest) {
        return null;
    }

    public GetSearchResultsResponseType
getSearchResults(GetSearchResultsRequestType
getSearchResultsRequest) {
        return null;
    }

    public GetSellerEventsResponseType
getSellerEvents(GetSellerEventsRequestType
getSellerEventsRequest) {
        return null;
    }

    public GetSellerListResponseType
getSellerList(GetSellerListRequestType
getSellerListRequest) {
        return null;
    }

    public GetSellerPaymentsResponseType
getSellerPayments(GetSellerPaymentsRequestType
getSellerPaymentsRequest) {
        return null;
    }

    public
GetSellerTransactionsResponseType
getSellerTransactions(GetSellerTransactionsRequestType
getSellerTransactionsRequest) {
        return null;
    }

    public GetStoreResponseType
getStore(GetStoreRequestType
getStoreRequest) {
        return null;
    }

    public
GetStoreCategoryUpdateStatusResponseType
getStoreCategoryUpdateStatus(GetStoreCategoryUpdateStatusRequestType
getStoreCategoryUpdateStatusRequest) {
        return null;
    }

    public GetStoreCustomPageResponseType
getStoreCustomPage(GetStoreCustomPageRequestType
getStoreCustomPageRequest) {
        return null;
    }

    public GetStoreOptionsResponseType
getStoreOptions(GetStoreOptionsRequestType
getStoreOptionsRequest) {
        return null;
    }

    public GetStorePreferencesResponseType
getStorePreferences(GetStorePreferencesRequestType
getStorePreferencesRequest) {
        return null;
    }

    public
GetSuggestedCategoriesResponseType
getSuggestedCategories(GetSuggestedCategoriesRequestType
getSuggestedCategoriesRequest) {
        return null;
    }

    public GetTaxTableResponseType
getTaxTable(GetTaxTableRequestType
getTaxTableRequest) {
        return null;
    }

    public GetUserResponseType
getUser(GetUserRequestType getUserRequest)
{
        return null;
    }

    public
GetUserContactDetailsResponseType
getUserContactDetails(GetUserContactDetailsRequestType
getUserContactDetailsRequest) {
        return null;
    }

    public GetUserDisputesResponseType
getUserDisputes(GetUserDisputesRequestType
getUserDisputesRequest) {
        return null;
    }

    public GetUserPreferencesResponseType
getUserPreferences(GetUserPreferencesRequestType
getUserPreferencesRequest) {
        return null;
    }

    public GetWantItNowPostResponseType
getWantItNowPost(GetWantItNowPostRequestType
getWantItNowPostRequest) {
        return null;
    }

    public
GetWantItNowSearchResultsResponseType
getWantItNowSearchResults(GetWantItNowSearchResultsRequestType
getWantItNowSearchResultsRequest) {
        return null;
    }

    public GeteBayDetailsResponseType
geteBayDetails(GeteBayDetailsRequestType
geteBayDetailsRequest) {
        return null;
    }

    public GeteBayOfficialTimeResponseType
geteBayOfficialTime(GeteBayOfficialTimeRequestType
geteBayOfficialTimeRequest) {
        return null;
    }

    public IssueRefundResponseType
issueRefund(IssueRefundRequestType
issueRefundRequest) {
        return null;
    }

    public LeaveFeedbackResponseType
leaveFeedback(LeaveFeedbackRequestType
leaveFeedbackRequest) {
        return null;
    }

    public PlaceOfferResponseType
placeOffer(PlaceOfferRequestType
placeOfferRequest) {
        return null;
    }

    public RelistItemResponseType
relistItem(RelistItemRequestType
relistItemRequest) {
        return null;
    }

    public RemoveFromWatchListResponseType
removeFromWatchList(RemoveFromWatchListRequestType
removeFromWatchListRequest) {
        return null;
    }

    public RespondToBestOfferResponseType
respondToBestOffer(RespondToBestOfferRequestType
respondToBestOfferRequest) {
        return null;
    }

    public RespondToFeedbackResponseType
respondToFeedback(RespondToFeedbackRequestType
respondToFeedbackRequest) {
        return null;
    }

    public
RespondToWantItNowPostResponseType
respondToWantItNowPost(RespondToWantItNowPostRequestType
respondToWantItNowPostRequest) {
        return null;
    }

    public ReviseCheckoutStatusResponseType
reviseCheckoutStatus(ReviseCheckoutStatusRequestType
reviseCheckoutStatusRequest) {
        return null;
    }

    public ReviseItemResponseType
reviseItem(ReviseItemRequestType
reviseItemRequest) {
        return null;
    }

    public
ReviseLiveAuctionItemResponseType
reviseLiveAuctionItem(ReviseLiveAuctionItemRequestType
reviseLiveAuctionItemRequest) {
        return null;
    }

    public ReviseMyMessagesResponseType
reviseMyMessages(ReviseMyMessagesRequestType
reviseMyMessagesRequest) {
        return null;
    }

    public
ReviseMyMessagesFoldersResponseType
reviseMyMessagesFolders(ReviseMyMessagesFoldersRequestType
reviseMyMessagesFoldersRequest) {
        return null;
    }

    public SellerReverseDisputeResponseType
sellerReverseDispute(SellerReverseDisputeRequestType
sellerReverseDisputeRequest) {
        return null;
    }

    public SendInvoiceResponseType
sendInvoice(SendInvoiceRequestType
sendInvoiceRequest) {
        return null;
    }

    public
SetNotificationPreferencesResponseType
setNotificationPreferences(SetNotificationPreferencesRequestType
setNotificationPreferencesRequest) {
        return null;
    }

    public
SetPictureManagerDetailsResponseType
setPictureManagerDetails(SetPictureManagerDetailsRequestType
setPictureManagerDetailsRequest) {
        return null;
    }

    public SetPromotionRulesResponseType
setPromotionRules(SetPromotionRulesRequestType
setPromotionRulesRequest) {
        return null;
    }

    public SetReturnURLResponseType
setReturnURL(SetReturnURLRequestType
setReturnURLRequest) {
        return null;
    }

    public SetStoreResponseType
setStore(SetStoreRequestType
setStoreRequest) {
        return null;
    }

    public SetStoreCategoriesResponseType
setStoreCategories(SetStoreCategoriesRequestType
setStoreCategoriesRequest) {
        return null;
    }

    public SetStoreCustomPageResponseType
setStoreCustomPage(SetStoreCustomPageRequestType
setStoreCustomPageRequest) {
        return null;
    }

    public SetStorePreferencesResponseType
setStorePreferences(SetStorePreferencesRequestType
setStorePreferencesRequest) {
        return null;
    }

    public SetTaxTableResponseType
setTaxTable(SetTaxTableRequestType
setTaxTableRequest) {
        return null;
    }

    public SetUserNotesResponseType
setUserNotes(SetUserNotesRequestType
setUserNotesRequest) {
        return null;
    }

    public SetUserPreferencesResponseType
setUserPreferences(SetUserPreferencesRequestType
setUserPreferencesRequest) {
        return null;
    }

    public
ValidateTestUserRegistrationResponseType
validateTestUserRegistration(ValidateTestUserRegistrationRequestType
validateTestUserRegistrationRequest) {
        return null;
    }

    public VerifyAddItemResponseType
verifyAddItem(VerifyAddItemRequestType
verifyAddItemRequest) {
        return null;
    }

    public
VerifyAddSecondChanceItemResponseType
verifyAddSecondChanceItem(VerifyAddSecondChanceItemRequestType
verifyAddSecondChanceItemRequest) {
        return null;
    }

}
