// Generated from AQL.g4 by ANTLR 4.1
package edu.common.dynamicextensions.query.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AQLParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, WS=3, SELECT=4, WHERE=5, NTHCHILD=6, BETWEEN=7, MTHS_BTWN=8, 
		YRS_BTWN=9, CURR_DATE=10, MINS_BTWN=11, COUNT=12, SUM=13, MIN=14, MAX=15, 
		AVG=16, DISTINCT=17, LIMIT=18, CROSSTAB=19, OR=20, AND=21, PAND=22, NOT=23, 
		ROUND=24, LP=25, RP=26, MOP=27, SOP=28, EOP=29, BOOL=30, OP=31, INT=32, 
		FLOAT=33, YEAR=34, MONTH=35, DAY=36, DIGIT=37, ID=38, FIELD=39, SLITERAL=40, 
		ESC=41, ARITH_OP=42, ERROR=43, QUOTE=44;
	public static final String[] tokenNames = {
		"<INVALID>", "'as'", "','", "WS", "'select'", "'where'", "'nthchild'", 
		"'between'", "'months_between'", "'years_between'", "'current_date'", 
		"'minutes_between'", "'count'", "'sum'", "'min'", "'max'", "'avg'", "'distinct'", 
		"'limit'", "'crosstab'", "'or'", "'and'", "'pand'", "'not'", "'round'", 
		"'('", "')'", "MOP", "SOP", "EOP", "BOOL", "OP", "INT", "FLOAT", "YEAR", 
		"MONTH", "DAY", "DIGIT", "ID", "FIELD", "SLITERAL", "ESC", "ARITH_OP", 
		"ERROR", "'\"'"
	};
	public static final int
		RULE_query = 0, RULE_select_list = 1, RULE_select_element = 2, RULE_filter_expr = 3, 
		RULE_limit_expr = 4, RULE_crosstab_expr = 5, RULE_report_expr = 6, RULE_filter = 7, 
		RULE_literal_values = 8, RULE_literal = 9, RULE_arith_expr = 10, RULE_agg_expr = 11, 
		RULE_date_interval = 12;
	public static final String[] ruleNames = {
		"query", "select_list", "select_element", "filter_expr", "limit_expr", 
		"crosstab_expr", "report_expr", "filter", "literal_values", "literal", 
		"arith_expr", "agg_expr", "date_interval"
	};

	@Override
	public String getGrammarFileName() { return "AQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public AQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
	 
		public QueryContext() { }
		public void copyFrom(QueryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QueryExprContext extends QueryContext {
		public TerminalNode WHERE() { return getToken(AQLParser.WHERE, 0); }
		public Filter_exprContext filter_expr() {
			return getRuleContext(Filter_exprContext.class,0);
		}
		public Crosstab_exprContext crosstab_expr() {
			return getRuleContext(Crosstab_exprContext.class,0);
		}
		public Report_exprContext report_expr() {
			return getRuleContext(Report_exprContext.class,0);
		}
		public Limit_exprContext limit_expr() {
			return getRuleContext(Limit_exprContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(AQLParser.SELECT, 0); }
		public Select_listContext select_list() {
			return getRuleContext(Select_listContext.class,0);
		}
		public QueryExprContext(QueryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterQueryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitQueryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitQueryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			_localctx = new QueryExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_la = _input.LA(1);
			if (_la==SELECT) {
				{
				setState(26); match(SELECT);
				setState(27); select_list();
				setState(28); match(WHERE);
				}
			}

			setState(32); filter_expr(0);
			setState(34);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(33); limit_expr();
				}
			}

			setState(38);
			switch (_input.LA(1)) {
			case CROSSTAB:
				{
				setState(36); crosstab_expr();
				}
				break;
			case ID:
				{
				setState(37); report_expr();
				}
				break;
			case EOF:
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_listContext extends ParserRuleContext {
		public Select_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_list; }
	 
		public Select_listContext() { }
		public void copyFrom(Select_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SelectExprContext extends Select_listContext {
		public Select_elementContext select_element(int i) {
			return getRuleContext(Select_elementContext.class,i);
		}
		public List<Select_elementContext> select_element() {
			return getRuleContexts(Select_elementContext.class);
		}
		public SelectExprContext(Select_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterSelectExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitSelectExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitSelectExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_listContext select_list() throws RecognitionException {
		Select_listContext _localctx = new Select_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_select_list);
		int _la;
		try {
			_localctx = new SelectExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(40); select_element();
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(41); match(2);
				setState(42); select_element();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_elementContext extends ParserRuleContext {
		public Select_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_element; }
	 
		public Select_elementContext() { }
		public void copyFrom(Select_elementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SelectElementContext extends Select_elementContext {
		public Arith_exprContext arith_expr() {
			return getRuleContext(Arith_exprContext.class,0);
		}
		public TerminalNode SLITERAL() { return getToken(AQLParser.SLITERAL, 0); }
		public SelectElementContext(Select_elementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterSelectElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitSelectElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitSelectElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_elementContext select_element() throws RecognitionException {
		Select_elementContext _localctx = new Select_elementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_select_element);
		int _la;
		try {
			_localctx = new SelectElementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(48); arith_expr(0);
			setState(51);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(49); match(1);
				setState(50); match(SLITERAL);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Filter_exprContext extends ParserRuleContext {
		public int _p;
		public Filter_exprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Filter_exprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_filter_expr; }
	 
		public Filter_exprContext() { }
		public void copyFrom(Filter_exprContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class NotFilterExprContext extends Filter_exprContext {
		public Filter_exprContext filter_expr() {
			return getRuleContext(Filter_exprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(AQLParser.NOT, 0); }
		public NotFilterExprContext(Filter_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterNotFilterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitNotFilterExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitNotFilterExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensFilterExprContext extends Filter_exprContext {
		public Filter_exprContext filter_expr() {
			return getRuleContext(Filter_exprContext.class,0);
		}
		public TerminalNode LP() { return getToken(AQLParser.LP, 0); }
		public TerminalNode RP() { return getToken(AQLParser.RP, 0); }
		public ParensFilterExprContext(Filter_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterParensFilterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitParensFilterExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitParensFilterExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrFilterExprContext extends Filter_exprContext {
		public List<Filter_exprContext> filter_expr() {
			return getRuleContexts(Filter_exprContext.class);
		}
		public Filter_exprContext filter_expr(int i) {
			return getRuleContext(Filter_exprContext.class,i);
		}
		public TerminalNode OR() { return getToken(AQLParser.OR, 0); }
		public OrFilterExprContext(Filter_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterOrFilterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitOrFilterExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitOrFilterExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PandFilterExprContext extends Filter_exprContext {
		public List<Filter_exprContext> filter_expr() {
			return getRuleContexts(Filter_exprContext.class);
		}
		public TerminalNode PAND() { return getToken(AQLParser.PAND, 0); }
		public Filter_exprContext filter_expr(int i) {
			return getRuleContext(Filter_exprContext.class,i);
		}
		public PandFilterExprContext(Filter_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterPandFilterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitPandFilterExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitPandFilterExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NthChildFilterExprContext extends Filter_exprContext {
		public Filter_exprContext filter_expr() {
			return getRuleContext(Filter_exprContext.class,0);
		}
		public TerminalNode LP() { return getToken(AQLParser.LP, 0); }
		public TerminalNode NTHCHILD() { return getToken(AQLParser.NTHCHILD, 0); }
		public TerminalNode RP() { return getToken(AQLParser.RP, 0); }
		public NthChildFilterExprContext(Filter_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterNthChildFilterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitNthChildFilterExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitNthChildFilterExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleFilterContext extends Filter_exprContext {
		public FilterContext filter() {
			return getRuleContext(FilterContext.class,0);
		}
		public SimpleFilterContext(Filter_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterSimpleFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitSimpleFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitSimpleFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndFilterExprContext extends Filter_exprContext {
		public List<Filter_exprContext> filter_expr() {
			return getRuleContexts(Filter_exprContext.class);
		}
		public TerminalNode AND() { return getToken(AQLParser.AND, 0); }
		public Filter_exprContext filter_expr(int i) {
			return getRuleContext(Filter_exprContext.class,i);
		}
		public AndFilterExprContext(Filter_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterAndFilterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitAndFilterExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitAndFilterExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Filter_exprContext filter_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Filter_exprContext _localctx = new Filter_exprContext(_ctx, _parentState, _p);
		Filter_exprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, RULE_filter_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new NotFilterExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(54); match(NOT);
				setState(55); filter_expr(2);
				}
				break;

			case 2:
				{
				_localctx = new ParensFilterExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56); match(LP);
				setState(57); filter_expr(0);
				setState(58); match(RP);
				}
				break;

			case 3:
				{
				_localctx = new NthChildFilterExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60); match(NTHCHILD);
				setState(61); match(LP);
				setState(62); filter_expr(0);
				setState(63); match(RP);
				}
				break;

			case 4:
				{
				_localctx = new SimpleFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65); filter();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(77);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new AndFilterExprContext(new Filter_exprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_filter_expr);
						setState(68);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(69); match(AND);
						setState(70); filter_expr(8);
						}
						break;

					case 2:
						{
						_localctx = new OrFilterExprContext(new Filter_exprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_filter_expr);
						setState(71);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(72); match(OR);
						setState(73); filter_expr(7);
						}
						break;

					case 3:
						{
						_localctx = new PandFilterExprContext(new Filter_exprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_filter_expr);
						setState(74);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(75); match(PAND);
						setState(76); filter_expr(6);
						}
						break;
					}
					} 
				}
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Limit_exprContext extends ParserRuleContext {
		public Limit_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit_expr; }
	 
		public Limit_exprContext() { }
		public void copyFrom(Limit_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LimitExprContext extends Limit_exprContext {
		public TerminalNode LIMIT() { return getToken(AQLParser.LIMIT, 0); }
		public List<TerminalNode> INT() { return getTokens(AQLParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(AQLParser.INT, i);
		}
		public LimitExprContext(Limit_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterLimitExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitLimitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitLimitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Limit_exprContext limit_expr() throws RecognitionException {
		Limit_exprContext _localctx = new Limit_exprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_limit_expr);
		int _la;
		try {
			_localctx = new LimitExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(82); match(LIMIT);
			setState(83); match(INT);
			setState(86);
			_la = _input.LA(1);
			if (_la==2) {
				{
				setState(84); match(2);
				setState(85); match(INT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Crosstab_exprContext extends ParserRuleContext {
		public Crosstab_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crosstab_expr; }
	 
		public Crosstab_exprContext() { }
		public void copyFrom(Crosstab_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CrossTabExprContext extends Crosstab_exprContext {
		public Token INT;
		public List<Token> row = new ArrayList<Token>();
		public Token col;
		public List<Token> value = new ArrayList<Token>();
		public TerminalNode BOOL() { return getToken(AQLParser.BOOL, 0); }
		public TerminalNode LP(int i) {
			return getToken(AQLParser.LP, i);
		}
		public List<TerminalNode> INT() { return getTokens(AQLParser.INT); }
		public List<TerminalNode> LP() { return getTokens(AQLParser.LP); }
		public List<TerminalNode> RP() { return getTokens(AQLParser.RP); }
		public TerminalNode INT(int i) {
			return getToken(AQLParser.INT, i);
		}
		public TerminalNode CROSSTAB() { return getToken(AQLParser.CROSSTAB, 0); }
		public TerminalNode RP(int i) {
			return getToken(AQLParser.RP, i);
		}
		public CrossTabExprContext(Crosstab_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterCrossTabExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitCrossTabExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitCrossTabExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Crosstab_exprContext crosstab_expr() throws RecognitionException {
		Crosstab_exprContext _localctx = new Crosstab_exprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_crosstab_expr);
		int _la;
		try {
			_localctx = new CrossTabExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(88); match(CROSSTAB);
			setState(89); match(LP);
			setState(90); match(LP);
			setState(91); ((CrossTabExprContext)_localctx).INT = match(INT);
			((CrossTabExprContext)_localctx).row.add(((CrossTabExprContext)_localctx).INT);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(92); match(2);
				setState(93); ((CrossTabExprContext)_localctx).INT = match(INT);
				((CrossTabExprContext)_localctx).row.add(((CrossTabExprContext)_localctx).INT);
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99); match(RP);
			setState(100); match(2);
			setState(101); ((CrossTabExprContext)_localctx).col = match(INT);
			setState(102); match(2);
			setState(103); match(LP);
			setState(104); ((CrossTabExprContext)_localctx).INT = match(INT);
			((CrossTabExprContext)_localctx).value.add(((CrossTabExprContext)_localctx).INT);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(105); match(2);
				setState(106); ((CrossTabExprContext)_localctx).INT = match(INT);
				((CrossTabExprContext)_localctx).value.add(((CrossTabExprContext)_localctx).INT);
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112); match(RP);
			setState(115);
			_la = _input.LA(1);
			if (_la==2) {
				{
				setState(113); match(2);
				setState(114); match(BOOL);
				}
			}

			setState(117); match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Report_exprContext extends ParserRuleContext {
		public Report_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_report_expr; }
	 
		public Report_exprContext() { }
		public void copyFrom(Report_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReportExprContext extends Report_exprContext {
		public List<TerminalNode> SLITERAL() { return getTokens(AQLParser.SLITERAL); }
		public TerminalNode LP() { return getToken(AQLParser.LP, 0); }
		public TerminalNode ID() { return getToken(AQLParser.ID, 0); }
		public TerminalNode RP() { return getToken(AQLParser.RP, 0); }
		public TerminalNode SLITERAL(int i) {
			return getToken(AQLParser.SLITERAL, i);
		}
		public ReportExprContext(Report_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterReportExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitReportExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitReportExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Report_exprContext report_expr() throws RecognitionException {
		Report_exprContext _localctx = new Report_exprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_report_expr);
		int _la;
		try {
			_localctx = new ReportExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(119); match(ID);
			setState(130);
			_la = _input.LA(1);
			if (_la==LP) {
				{
				setState(120); match(LP);
				setState(121); match(SLITERAL);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==2) {
					{
					{
					setState(122); match(2);
					setState(123); match(SLITERAL);
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(129); match(RP);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilterContext extends ParserRuleContext {
		public FilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter; }
	 
		public FilterContext() { }
		public void copyFrom(FilterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BasicFilterContext extends FilterContext {
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public TerminalNode OP() { return getToken(AQLParser.OP, 0); }
		public BasicFilterContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterBasicFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitBasicFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitBasicFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringCompFilterContext extends FilterContext {
		public TerminalNode SLITERAL() { return getToken(AQLParser.SLITERAL, 0); }
		public TerminalNode SOP() { return getToken(AQLParser.SOP, 0); }
		public TerminalNode FIELD() { return getToken(AQLParser.FIELD, 0); }
		public StringCompFilterContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterStringCompFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitStringCompFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitStringCompFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExistsFilterContext extends FilterContext {
		public TerminalNode EOP() { return getToken(AQLParser.EOP, 0); }
		public TerminalNode FIELD() { return getToken(AQLParser.FIELD, 0); }
		public ExistsFilterContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterExistsFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitExistsFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitExistsFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MvFilterContext extends FilterContext {
		public Arith_exprContext arith_expr() {
			return getRuleContext(Arith_exprContext.class,0);
		}
		public TerminalNode MOP() { return getToken(AQLParser.MOP, 0); }
		public Literal_valuesContext literal_values() {
			return getRuleContext(Literal_valuesContext.class,0);
		}
		public MvFilterContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterMvFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitMvFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitMvFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BetweenFilterContext extends FilterContext {
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public TerminalNode BETWEEN() { return getToken(AQLParser.BETWEEN, 0); }
		public TerminalNode LP() { return getToken(AQLParser.LP, 0); }
		public TerminalNode RP() { return getToken(AQLParser.RP, 0); }
		public TerminalNode FIELD() { return getToken(AQLParser.FIELD, 0); }
		public BetweenFilterContext(FilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterBetweenFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitBetweenFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitBetweenFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterContext filter() throws RecognitionException {
		FilterContext _localctx = new FilterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_filter);
		try {
			setState(153);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new BasicFilterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(132); arith_expr(0);
				setState(133); match(OP);
				setState(134); arith_expr(0);
				}
				break;

			case 2:
				_localctx = new MvFilterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(136); arith_expr(0);
				setState(137); match(MOP);
				setState(138); literal_values();
				}
				break;

			case 3:
				_localctx = new StringCompFilterContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(140); match(FIELD);
				setState(141); match(SOP);
				setState(142); match(SLITERAL);
				}
				break;

			case 4:
				_localctx = new ExistsFilterContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(143); match(FIELD);
				setState(144); match(EOP);
				}
				break;

			case 5:
				_localctx = new BetweenFilterContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(145); match(FIELD);
				setState(146); match(BETWEEN);
				setState(147); match(LP);
				setState(148); arith_expr(0);
				setState(149); match(2);
				setState(150); arith_expr(0);
				setState(151); match(RP);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Literal_valuesContext extends ParserRuleContext {
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public Literal_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterLiteral_values(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitLiteral_values(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitLiteral_values(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_valuesContext literal_values() throws RecognitionException {
		Literal_valuesContext _localctx = new Literal_valuesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_literal_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); match(LP);
			setState(156); literal();
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(157); match(2);
				setState(158); literal();
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164); match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringLiteralContext extends LiteralContext {
		public TerminalNode SLITERAL() { return getToken(AQLParser.SLITERAL, 0); }
		public StringLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolLiteralContext extends LiteralContext {
		public TerminalNode BOOL() { return getToken(AQLParser.BOOL, 0); }
		public BoolLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitBoolLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatLiteralContext extends LiteralContext {
		public TerminalNode FLOAT() { return getToken(AQLParser.FLOAT, 0); }
		public FloatLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterFloatLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitFloatLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitFloatLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLiteralContext extends LiteralContext {
		public TerminalNode INT() { return getToken(AQLParser.INT, 0); }
		public IntLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_literal);
		try {
			setState(170);
			switch (_input.LA(1)) {
			case SLITERAL:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(166); match(SLITERAL);
				}
				break;
			case INT:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(167); match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(168); match(FLOAT);
				}
				break;
			case BOOL:
				_localctx = new BoolLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(169); match(BOOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arith_exprContext extends ParserRuleContext {
		public int _p;
		public Arith_exprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Arith_exprContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_arith_expr; }
	 
		public Arith_exprContext() { }
		public void copyFrom(Arith_exprContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class MinsDiffFuncContext extends Arith_exprContext {
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public TerminalNode LP() { return getToken(AQLParser.LP, 0); }
		public TerminalNode RP() { return getToken(AQLParser.RP, 0); }
		public TerminalNode MINS_BTWN() { return getToken(AQLParser.MINS_BTWN, 0); }
		public MinsDiffFuncContext(Arith_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterMinsDiffFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitMinsDiffFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitMinsDiffFunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldContext extends Arith_exprContext {
		public TerminalNode FIELD() { return getToken(AQLParser.FIELD, 0); }
		public FieldContext(Arith_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AggExprContext extends Arith_exprContext {
		public Agg_exprContext agg_expr() {
			return getRuleContext(Agg_exprContext.class,0);
		}
		public AggExprContext(Arith_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterAggExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitAggExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitAggExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithExprContext extends Arith_exprContext {
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public TerminalNode ARITH_OP() { return getToken(AQLParser.ARITH_OP, 0); }
		public ArithExprContext(Arith_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterArithExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitArithExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitArithExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CurrentDateFuncContext extends Arith_exprContext {
		public TerminalNode LP() { return getToken(AQLParser.LP, 0); }
		public TerminalNode CURR_DATE() { return getToken(AQLParser.CURR_DATE, 0); }
		public TerminalNode RP() { return getToken(AQLParser.RP, 0); }
		public CurrentDateFuncContext(Arith_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterCurrentDateFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitCurrentDateFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitCurrentDateFunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class YearsDiffFuncContext extends Arith_exprContext {
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public TerminalNode LP() { return getToken(AQLParser.LP, 0); }
		public TerminalNode YRS_BTWN() { return getToken(AQLParser.YRS_BTWN, 0); }
		public TerminalNode RP() { return getToken(AQLParser.RP, 0); }
		public YearsDiffFuncContext(Arith_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterYearsDiffFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitYearsDiffFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitYearsDiffFunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DateIntervalExprContext extends Arith_exprContext {
		public Arith_exprContext arith_expr() {
			return getRuleContext(Arith_exprContext.class,0);
		}
		public TerminalNode ARITH_OP() { return getToken(AQLParser.ARITH_OP, 0); }
		public Date_intervalContext date_interval() {
			return getRuleContext(Date_intervalContext.class,0);
		}
		public DateIntervalExprContext(Arith_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterDateIntervalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitDateIntervalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitDateIntervalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensArithExprContext extends Arith_exprContext {
		public Arith_exprContext arith_expr() {
			return getRuleContext(Arith_exprContext.class,0);
		}
		public TerminalNode LP() { return getToken(AQLParser.LP, 0); }
		public TerminalNode RP() { return getToken(AQLParser.RP, 0); }
		public ParensArithExprContext(Arith_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterParensArithExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitParensArithExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitParensArithExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MonthsDiffFuncContext extends Arith_exprContext {
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public TerminalNode MTHS_BTWN() { return getToken(AQLParser.MTHS_BTWN, 0); }
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public TerminalNode LP() { return getToken(AQLParser.LP, 0); }
		public TerminalNode RP() { return getToken(AQLParser.RP, 0); }
		public MonthsDiffFuncContext(Arith_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterMonthsDiffFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitMonthsDiffFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitMonthsDiffFunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralValContext extends Arith_exprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralValContext(Arith_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterLiteralVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitLiteralVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitLiteralVal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RoundFuncContext extends Arith_exprContext {
		public Arith_exprContext arith_expr() {
			return getRuleContext(Arith_exprContext.class,0);
		}
		public TerminalNode INT() { return getToken(AQLParser.INT, 0); }
		public TerminalNode LP() { return getToken(AQLParser.LP, 0); }
		public TerminalNode RP() { return getToken(AQLParser.RP, 0); }
		public TerminalNode ROUND() { return getToken(AQLParser.ROUND, 0); }
		public RoundFuncContext(Arith_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterRoundFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitRoundFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitRoundFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arith_exprContext arith_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arith_exprContext _localctx = new Arith_exprContext(_ctx, _parentState, _p);
		Arith_exprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, RULE_arith_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			switch (_input.LA(1)) {
			case LP:
				{
				_localctx = new ParensArithExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(173); match(LP);
				setState(174); arith_expr(0);
				setState(175); match(RP);
				}
				break;
			case MTHS_BTWN:
				{
				_localctx = new MonthsDiffFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177); match(MTHS_BTWN);
				setState(178); match(LP);
				setState(179); arith_expr(0);
				setState(180); match(2);
				setState(181); arith_expr(0);
				setState(182); match(RP);
				}
				break;
			case YRS_BTWN:
				{
				_localctx = new YearsDiffFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184); match(YRS_BTWN);
				setState(185); match(LP);
				setState(186); arith_expr(0);
				setState(187); match(2);
				setState(188); arith_expr(0);
				setState(189); match(RP);
				}
				break;
			case MINS_BTWN:
				{
				_localctx = new MinsDiffFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191); match(MINS_BTWN);
				setState(192); match(LP);
				setState(193); arith_expr(0);
				setState(194); match(2);
				setState(195); arith_expr(0);
				setState(196); match(RP);
				}
				break;
			case CURR_DATE:
				{
				_localctx = new CurrentDateFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198); match(CURR_DATE);
				setState(199); match(LP);
				setState(200); match(RP);
				}
				break;
			case COUNT:
			case SUM:
			case MIN:
			case MAX:
			case AVG:
				{
				_localctx = new AggExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201); agg_expr();
				}
				break;
			case ROUND:
				{
				_localctx = new RoundFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202); match(ROUND);
				setState(203); match(LP);
				setState(204); arith_expr(0);
				setState(205); match(2);
				setState(206); match(INT);
				setState(207); match(RP);
				}
				break;
			case FIELD:
				{
				_localctx = new FieldContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209); match(FIELD);
				}
				break;
			case BOOL:
			case INT:
			case FLOAT:
			case SLITERAL:
				{
				_localctx = new LiteralValContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210); literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(221);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(219);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ArithExprContext(new Arith_exprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_arith_expr);
						setState(213);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(214); match(ARITH_OP);
						setState(215); arith_expr(12);
						}
						break;

					case 2:
						{
						_localctx = new DateIntervalExprContext(new Arith_exprContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_arith_expr);
						setState(216);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(217); match(ARITH_OP);
						setState(218); date_interval();
						}
						break;
					}
					} 
				}
				setState(223);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Agg_exprContext extends ParserRuleContext {
		public Agg_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agg_expr; }
	 
		public Agg_exprContext() { }
		public void copyFrom(Agg_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AggFuncContext extends Agg_exprContext {
		public TerminalNode COUNT() { return getToken(AQLParser.COUNT, 0); }
		public TerminalNode SUM() { return getToken(AQLParser.SUM, 0); }
		public TerminalNode DISTINCT() { return getToken(AQLParser.DISTINCT, 0); }
		public TerminalNode LP() { return getToken(AQLParser.LP, 0); }
		public TerminalNode AVG() { return getToken(AQLParser.AVG, 0); }
		public TerminalNode RP() { return getToken(AQLParser.RP, 0); }
		public TerminalNode MIN() { return getToken(AQLParser.MIN, 0); }
		public TerminalNode MAX() { return getToken(AQLParser.MAX, 0); }
		public TerminalNode FIELD() { return getToken(AQLParser.FIELD, 0); }
		public AggFuncContext(Agg_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterAggFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitAggFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitAggFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Agg_exprContext agg_expr() throws RecognitionException {
		Agg_exprContext _localctx = new Agg_exprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_agg_expr);
		int _la;
		try {
			_localctx = new AggFuncContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COUNT) | (1L << SUM) | (1L << MIN) | (1L << MAX) | (1L << AVG))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(225); match(LP);
			setState(227);
			_la = _input.LA(1);
			if (_la==DISTINCT) {
				{
				setState(226); match(DISTINCT);
				}
			}

			setState(229); match(FIELD);
			setState(230); match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Date_intervalContext extends ParserRuleContext {
		public TerminalNode YEAR() { return getToken(AQLParser.YEAR, 0); }
		public TerminalNode MONTH() { return getToken(AQLParser.MONTH, 0); }
		public TerminalNode DAY() { return getToken(AQLParser.DAY, 0); }
		public Date_intervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_interval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).enterDate_interval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AQLListener ) ((AQLListener)listener).exitDate_interval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AQLVisitor ) return ((AQLVisitor<? extends T>)visitor).visitDate_interval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Date_intervalContext date_interval() throws RecognitionException {
		Date_intervalContext _localctx = new Date_intervalContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_date_interval);
		int _la;
		try {
			setState(253);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232); match(YEAR);
				setState(234);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(233); match(MONTH);
					}
					break;
				}
				setState(237);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(236); match(DAY);
					}
					break;
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				_la = _input.LA(1);
				if (_la==YEAR) {
					{
					setState(239); match(YEAR);
					}
				}

				setState(242); match(MONTH);
				setState(244);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(243); match(DAY);
					}
					break;
				}
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				_la = _input.LA(1);
				if (_la==YEAR) {
					{
					setState(246); match(YEAR);
					}
				}

				setState(250);
				_la = _input.LA(1);
				if (_la==MONTH) {
					{
					setState(249); match(MONTH);
					}
				}

				setState(252); match(DAY);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3: return filter_expr_sempred((Filter_exprContext)_localctx, predIndex);

		case 10: return arith_expr_sempred((Arith_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean filter_expr_sempred(Filter_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 7 >= _localctx._p;

		case 1: return 6 >= _localctx._p;

		case 2: return 5 >= _localctx._p;
		}
		return true;
	}
	private boolean arith_expr_sempred(Arith_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return 11 >= _localctx._p;

		case 4: return 10 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3.\u0102\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\5\2!\n\2\3\2\3\2\5\2%\n"+
		"\2\3\2\3\2\5\2)\n\2\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\4\3\4\3\4"+
		"\5\4\66\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5E\n"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5P\n\5\f\5\16\5S\13\5\3\6\3\6"+
		"\3\6\3\6\5\6Y\n\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7a\n\7\f\7\16\7d\13\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7n\n\7\f\7\16\7q\13\7\3\7\3\7\3\7\5\7v"+
		"\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\b\177\n\b\f\b\16\b\u0082\13\b\3\b\5"+
		"\b\u0085\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u009c\n\t\3\n\3\n\3\n\3\n\7\n\u00a2\n\n"+
		"\f\n\16\n\u00a5\13\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u00ad\n\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u00d6\n\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00de\n\f\f\f\16"+
		"\f\u00e1\13\f\3\r\3\r\3\r\5\r\u00e6\n\r\3\r\3\r\3\r\3\16\3\16\5\16\u00ed"+
		"\n\16\3\16\5\16\u00f0\n\16\3\16\5\16\u00f3\n\16\3\16\3\16\5\16\u00f7\n"+
		"\16\3\16\5\16\u00fa\n\16\3\16\5\16\u00fd\n\16\3\16\5\16\u0100\n\16\3\16"+
		"\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\3\3\2\16\22\u0121\2 \3\2\2\2"+
		"\4*\3\2\2\2\6\62\3\2\2\2\bD\3\2\2\2\nT\3\2\2\2\fZ\3\2\2\2\16y\3\2\2\2"+
		"\20\u009b\3\2\2\2\22\u009d\3\2\2\2\24\u00ac\3\2\2\2\26\u00d5\3\2\2\2\30"+
		"\u00e2\3\2\2\2\32\u00ff\3\2\2\2\34\35\7\6\2\2\35\36\5\4\3\2\36\37\7\7"+
		"\2\2\37!\3\2\2\2 \34\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"$\5\b\5\2#%\5\n\6\2"+
		"$#\3\2\2\2$%\3\2\2\2%(\3\2\2\2&)\5\f\7\2\')\5\16\b\2(&\3\2\2\2(\'\3\2"+
		"\2\2()\3\2\2\2)\3\3\2\2\2*/\5\6\4\2+,\7\4\2\2,.\5\6\4\2-+\3\2\2\2.\61"+
		"\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\5\3\2\2\2\61/\3\2\2\2\62\65\5\26\f\2"+
		"\63\64\7\3\2\2\64\66\7*\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\7\3\2\2\2\67"+
		"8\b\5\1\289\7\31\2\29E\5\b\5\2:;\7\33\2\2;<\5\b\5\2<=\7\34\2\2=E\3\2\2"+
		"\2>?\7\b\2\2?@\7\33\2\2@A\5\b\5\2AB\7\34\2\2BE\3\2\2\2CE\5\20\t\2D\67"+
		"\3\2\2\2D:\3\2\2\2D>\3\2\2\2DC\3\2\2\2EQ\3\2\2\2FG\6\5\2\3GH\7\27\2\2"+
		"HP\5\b\5\2IJ\6\5\3\3JK\7\26\2\2KP\5\b\5\2LM\6\5\4\3MN\7\30\2\2NP\5\b\5"+
		"\2OF\3\2\2\2OI\3\2\2\2OL\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\t\3\2"+
		"\2\2SQ\3\2\2\2TU\7\24\2\2UX\7\"\2\2VW\7\4\2\2WY\7\"\2\2XV\3\2\2\2XY\3"+
		"\2\2\2Y\13\3\2\2\2Z[\7\25\2\2[\\\7\33\2\2\\]\7\33\2\2]b\7\"\2\2^_\7\4"+
		"\2\2_a\7\"\2\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2"+
		"\2\2ef\7\34\2\2fg\7\4\2\2gh\7\"\2\2hi\7\4\2\2ij\7\33\2\2jo\7\"\2\2kl\7"+
		"\4\2\2ln\7\"\2\2mk\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3"+
		"\2\2\2ru\7\34\2\2st\7\4\2\2tv\7 \2\2us\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\7"+
		"\34\2\2x\r\3\2\2\2y\u0084\7(\2\2z{\7\33\2\2{\u0080\7*\2\2|}\7\4\2\2}\177"+
		"\7*\2\2~|\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2"+
		"\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085\7\34\2\2\u0084z\3"+
		"\2\2\2\u0084\u0085\3\2\2\2\u0085\17\3\2\2\2\u0086\u0087\5\26\f\2\u0087"+
		"\u0088\7!\2\2\u0088\u0089\5\26\f\2\u0089\u009c\3\2\2\2\u008a\u008b\5\26"+
		"\f\2\u008b\u008c\7\35\2\2\u008c\u008d\5\22\n\2\u008d\u009c\3\2\2\2\u008e"+
		"\u008f\7)\2\2\u008f\u0090\7\36\2\2\u0090\u009c\7*\2\2\u0091\u0092\7)\2"+
		"\2\u0092\u009c\7\37\2\2\u0093\u0094\7)\2\2\u0094\u0095\7\t\2\2\u0095\u0096"+
		"\7\33\2\2\u0096\u0097\5\26\f\2\u0097\u0098\7\4\2\2\u0098\u0099\5\26\f"+
		"\2\u0099\u009a\7\34\2\2\u009a\u009c\3\2\2\2\u009b\u0086\3\2\2\2\u009b"+
		"\u008a\3\2\2\2\u009b\u008e\3\2\2\2\u009b\u0091\3\2\2\2\u009b\u0093\3\2"+
		"\2\2\u009c\21\3\2\2\2\u009d\u009e\7\33\2\2\u009e\u00a3\5\24\13\2\u009f"+
		"\u00a0\7\4\2\2\u00a0\u00a2\5\24\13\2\u00a1\u009f\3\2\2\2\u00a2\u00a5\3"+
		"\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a6\u00a7\7\34\2\2\u00a7\23\3\2\2\2\u00a8\u00ad\7*\2"+
		"\2\u00a9\u00ad\7\"\2\2\u00aa\u00ad\7#\2\2\u00ab\u00ad\7 \2\2\u00ac\u00a8"+
		"\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad"+
		"\25\3\2\2\2\u00ae\u00af\b\f\1\2\u00af\u00b0\7\33\2\2\u00b0\u00b1\5\26"+
		"\f\2\u00b1\u00b2\7\34\2\2\u00b2\u00d6\3\2\2\2\u00b3\u00b4\7\n\2\2\u00b4"+
		"\u00b5\7\33\2\2\u00b5\u00b6\5\26\f\2\u00b6\u00b7\7\4\2\2\u00b7\u00b8\5"+
		"\26\f\2\u00b8\u00b9\7\34\2\2\u00b9\u00d6\3\2\2\2\u00ba\u00bb\7\13\2\2"+
		"\u00bb\u00bc\7\33\2\2\u00bc\u00bd\5\26\f\2\u00bd\u00be\7\4\2\2\u00be\u00bf"+
		"\5\26\f\2\u00bf\u00c0\7\34\2\2\u00c0\u00d6\3\2\2\2\u00c1\u00c2\7\r\2\2"+
		"\u00c2\u00c3\7\33\2\2\u00c3\u00c4\5\26\f\2\u00c4\u00c5\7\4\2\2\u00c5\u00c6"+
		"\5\26\f\2\u00c6\u00c7\7\34\2\2\u00c7\u00d6\3\2\2\2\u00c8\u00c9\7\f\2\2"+
		"\u00c9\u00ca\7\33\2\2\u00ca\u00d6\7\34\2\2\u00cb\u00d6\5\30\r\2\u00cc"+
		"\u00cd\7\32\2\2\u00cd\u00ce\7\33\2\2\u00ce\u00cf\5\26\f\2\u00cf\u00d0"+
		"\7\4\2\2\u00d0\u00d1\7\"\2\2\u00d1\u00d2\7\34\2\2\u00d2\u00d6\3\2\2\2"+
		"\u00d3\u00d6\7)\2\2\u00d4\u00d6\5\24\13\2\u00d5\u00ae\3\2\2\2\u00d5\u00b3"+
		"\3\2\2\2\u00d5\u00ba\3\2\2\2\u00d5\u00c1\3\2\2\2\u00d5\u00c8\3\2\2\2\u00d5"+
		"\u00cb\3\2\2\2\u00d5\u00cc\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2"+
		"\2\2\u00d6\u00df\3\2\2\2\u00d7\u00d8\6\f\5\3\u00d8\u00d9\7,\2\2\u00d9"+
		"\u00de\5\26\f\2\u00da\u00db\6\f\6\3\u00db\u00dc\7,\2\2\u00dc\u00de\5\32"+
		"\16\2\u00dd\u00d7\3\2\2\2\u00dd\u00da\3\2\2\2\u00de\u00e1\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\27\3\2\2\2\u00e1\u00df\3\2\2"+
		"\2\u00e2\u00e3\t\2\2\2\u00e3\u00e5\7\33\2\2\u00e4\u00e6\7\23\2\2\u00e5"+
		"\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\7)"+
		"\2\2\u00e8\u00e9\7\34\2\2\u00e9\31\3\2\2\2\u00ea\u00ec\7$\2\2\u00eb\u00ed"+
		"\7%\2\2\u00ec\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee"+
		"\u00f0\7&\2\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u0100\3\2"+
		"\2\2\u00f1\u00f3\7$\2\2\u00f2\u00f1\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f6\7%\2\2\u00f5\u00f7\7&\2\2\u00f6\u00f5\3\2\2"+
		"\2\u00f6\u00f7\3\2\2\2\u00f7\u0100\3\2\2\2\u00f8\u00fa\7$\2\2\u00f9\u00f8"+
		"\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00fd\7%\2\2\u00fc"+
		"\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\7&"+
		"\2\2\u00ff\u00ea\3\2\2\2\u00ff\u00f2\3\2\2\2\u00ff\u00f9\3\2\2\2\u0100"+
		"\33\3\2\2\2\36 $(/\65DOQXbou\u0080\u0084\u009b\u00a3\u00ac\u00d5\u00dd"+
		"\u00df\u00e5\u00ec\u00ef\u00f2\u00f6\u00f9\u00fc\u00ff";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}